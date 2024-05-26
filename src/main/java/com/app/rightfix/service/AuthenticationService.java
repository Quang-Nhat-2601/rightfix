package com.app.rightfix.service;

import com.app.rightfix.dto.request.AuthenticationRequest;
import com.app.rightfix.dto.request.IntrospectRequest;
import com.app.rightfix.dto.request.LogoutRequest;
import com.app.rightfix.dto.request.RefreshRequest;
import com.app.rightfix.dto.response.AuthenticationResponse;
import com.app.rightfix.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {
    IntrospectResponse introspect(IntrospectRequest request) throws  ParseException;
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void logout(LogoutRequest request) throws ParseException;
    AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException;

}
