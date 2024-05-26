package com.app.rightfix.service.impl;

import com.app.rightfix.dao.UserDAO;
import com.app.rightfix.dto.request.AuthenticationRequest;
import com.app.rightfix.dto.request.IntrospectRequest;
import com.app.rightfix.dto.request.LogoutRequest;
import com.app.rightfix.dto.request.RefreshRequest;
import com.app.rightfix.dto.response.AuthenticationResponse;
import com.app.rightfix.dto.response.IntrospectResponse;
import com.app.rightfix.repository.InvalidatedTokenRepository;
import com.app.rightfix.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDAO userDAO;
    private final InvalidatedTokenRepository invalidatedTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final static String SIGNER_KEY = "vhBhEKJSmjOXUPPOrywyRLa2J0a9jZoH5dkiSGzQ9D0ffaK6GgwffR73vRGX77K3\n";

    @Autowired
    public AuthenticationServiceImpl(UserDAO userDAO, InvalidatedTokenRepository invalidatedTokenRepository,@Lazy PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.invalidatedTokenRepository = invalidatedTokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws ParseException {
       return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userDAO.findByName(request.getEmail())
                .orElseThrow(() -> new RuntimeException("not found"));
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        boolean authenticated = passwordEncoder.matches(encodedPassword, user.getPassword());
        log.debug("Password retrieved from database: {}", user.getPassword());
        if (!authenticated) {
            throw new RuntimeException("Unauthenticated");
        }
        var token = generateToken(request.getEmail());
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    @Override
    public void logout(LogoutRequest request) throws ParseException {

    }

    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException {
        return null;
    }
    private String generateToken(String username){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("rightfix.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("CustomClaim", "Custom")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("cannot create token");
            throw new RuntimeException(e);
        }
    }
}
