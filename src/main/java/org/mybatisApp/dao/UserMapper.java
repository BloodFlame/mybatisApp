package org.mybatisApp.dao;

import org.mybatisApp.model.User;

public interface UserMapper {
    User selectUserById(int id);
    int insertUser(User user);
}
