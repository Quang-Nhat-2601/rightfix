package com.app.rightfix.service;

import com.app.rightfix.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // Create
    void saveUser(User user);

    // Read
    UserDetails loadUserById(Long id);

    // Update
    void updateUser(User user);

    // Delete
    void deleteUser(Long id);
}
