package com.app.rightfix.dao;

import com.app.rightfix.entity.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
<<<<<<< HEAD
    User findById(Long id);
    List<User> findAll();
    void update(User user);
    void delete(Long id);
=======
    User findUserById(long id);
>>>>>>> main
}
