package org.mybatisApp.dao;

import org.mybatisApp.model.User;

import java.util.ArrayList;

public interface UserMapper {
    User selectUserById(int id);
    int insertUser(User user);
    int insertBatchUser(ArrayList<User> list);
}
