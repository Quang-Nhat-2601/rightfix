package com.app.rightfix.controller;

import com.app.rightfix.dto.response.ApiResponse;
import com.app.rightfix.entity.User;
import com.app.rightfix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/api/v1")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user) {
        userService.saveUser(user);
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", user);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", user);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUserShop() {
        List<User> user = userService.getAllUser();
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUserShop(@PathVariable Long id, @RequestBody User user) {
        User itemUser = userService.getUserById(id);
        if (itemUser != null) {
            user.setId(id);
            userService.updateUser(user);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", user);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUserShop(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            ApiResponse apiResponse = new ApiResponse(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
    }
}
