package com.app.rightfix.service;

import com.app.rightfix.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // Create
    void saveUser(User user);

    // Read
    Optional<User> getUserById(Long id);

    List<User> getAllUser();

    // Update
    void updateUser(User user);

    // Delete
    void deleteUser(Long id);
}
