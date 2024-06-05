package com.app.rightfix.controller;

import com.app.rightfix.dto.RegisterDTO;
import com.app.rightfix.dto.Response;
import com.app.rightfix.entity.User;
import com.app.rightfix.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            User savedUser = new User(registerDTO.getEmail(), passwordEncoder.encode(registerDTO.getPassword()));
            userService.saveUser(savedUser);
            response =  new Response(HttpStatus.OK.value(), "successful", null);
        } catch (Exception e) {
            response =  new Response(HttpStatus.OK.value(), "failed", null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Response> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            Response response = new Response(HttpStatus.OK.value(), "successfully", user);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        } else {
//            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }
//    @GetMapping("/get/all")
//    public ResponseEntity<List<User>> getAllUserShop() {
//        List<User> user = userService.getAllUser();
//        return ResponseEntity.ok().body(user);
//    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Response> updateUserShop(@PathVariable Long id, @RequestBody User user) {
//        User itemUser = userService.getUserById(id);
//        if (itemUser != null) {
//            user.setId(id);
//            userService.updateUser(user);
//            Response response = new Response(HttpStatus.OK.value(), "successfully", user);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        } else {
//            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Response> deleteUserShop(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        if (user != null) {
//            userService.deleteUser(id);
//            Response response = new Response(HttpStatus.OK.value(), "successfully", null);
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        } else {
//            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//    }
}
