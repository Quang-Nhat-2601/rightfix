package com.app.rightfix.controller;

import com.app.rightfix.config.JwtTokenProvider;
import com.app.rightfix.config.UsernamePasswordAuthenticationProvider;
import com.app.rightfix.dto.RegisterDTO;
import com.app.rightfix.entity.CustomUserDetails;
import com.app.rightfix.entity.User;
import com.app.rightfix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsernamePasswordAuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public String registerUser(@RequestBody RegisterDTO registerDTO) {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerDTO.getUsername(),
                        registerDTO.getPassword()
                )
        );
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        List<User> users = userRepository.findByUsername(registerDTO.getUsername());
        if(users.isEmpty()) {
            throw new UsernameNotFoundException("not found user!");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(users.get(0));
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken(customUserDetails);
        return jwt;
    }

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public String randomStuff(){
        return "authenticated";
    }
}
