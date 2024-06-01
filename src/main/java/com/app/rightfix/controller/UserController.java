package com.app.rightfix.controller;

import com.app.rightfix.dto.Response;
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
    public ResponseEntity<Response> createUser(@RequestBody User user) {
        userService.saveUser(user);
        Response response = new Response(HttpStatus.OK.value(), "successfully", user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            Response response = new Response(HttpStatus.OK.value(), "successfully", user);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUserShop() {
        List<User> user = userService.getAllUser();
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUserShop(@PathVariable Long id, @RequestBody User user) {
        User itemUser = userService.getUserById(id);
        if (itemUser != null) {
            user.setId(id);
            userService.updateUser(user);
            Response response = new Response(HttpStatus.OK.value(), "successfully", user);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUserShop(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            Response response = new Response(HttpStatus.OK.value(), "successfully", null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
