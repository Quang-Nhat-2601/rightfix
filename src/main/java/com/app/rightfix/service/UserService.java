package com.app.rightfix.service;

import com.app.rightfix.entity.User;

import java.util.List;

public interface UserService {
    // Create
    void saveUser(User user);

    // Read
    User getUserById(Long id);

    List<User> getAllUser();

    // Update
    void updateUser(User user);

    // Delete
    void deleteUser(Long id);
}
