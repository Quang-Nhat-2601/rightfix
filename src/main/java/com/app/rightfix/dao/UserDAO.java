package com.app.rightfix.dao;

import com.app.rightfix.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void save(User user);
    User findById(Long id);
    Optional<User> findByName(String email);
    List<User> findAll();
    void update(User user);
    void delete(Long id);
}
