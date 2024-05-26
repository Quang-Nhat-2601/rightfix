package com.app.rightfix.config;

import com.app.rightfix.dto.request.IntrospectRequest;
import com.app.rightfix.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

@Component
public class CustomJwtDecoder implements JwtDecoder {

    private final static String SIGNER_KEY = "vhBhEKJSmjOXUPPOrywyRLa2J0a9jZoH5dkiSGzQ9D0ffaK6GgwffR73vRGX77K3\n";

    private final AuthenticationService authenticationService;
    private NimbusJwtDecoder nimbusJwtDecoder;

    @Autowired
    public CustomJwtDecoder(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
        this.nimbusJwtDecoder = createNimbusJwtDecoder();
    }

    private NimbusJwtDecoder createNimbusJwtDecoder() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
        return NimbusJwtDecoder.withSecretKey(secretKeySpec)
                .build();
    }

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            var response = authenticationService.introspect(
                    IntrospectRequest.builder().token(token).build());

            if (!response.isValid()) {
                throw new JwtException("Token invalid");
            }
        } catch (ParseException e) {
            throw new JwtException(e.getMessage());
        }

        return nimbusJwtDecoder.decode(token);
    }
}
