package com.app.rightfix.controller;

import com.app.rightfix.dto.RegisterDTO;
import com.app.rightfix.dto.Response;
import com.app.rightfix.entity.User;
import com.app.rightfix.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/api/v1")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterDTO registerDTO) {
        Response response = null;
        try {
            User savedUser = new User(
                    registerDTO.getFullName()
                    , registerDTO.getGender()
                    , registerDTO.getDob()
                    , registerDTO.getUsername()
                    , registerDTO.getEmail()
                    , passwordEncoder.encode(registerDTO.getPassword()));
            userService.saveUser(savedUser);
            response = new Response(HttpStatus.OK.value(), "successful", null);
        } catch (Exception e) {
            response = new Response(HttpStatus.OK.value(), "failed", null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
