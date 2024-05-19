package com.app.rightfix.dao;

import com.app.rightfix.Entities.User;

public interface UserDAO {
    void save(User user);
    User findUserById(long id);
}
