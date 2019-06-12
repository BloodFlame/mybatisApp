package org.mybatisApp.dao;

import org.mybatisApp.model.User;

public interface UserDao {
    User getUserById(int id);
    int insertUser(User user);
}
