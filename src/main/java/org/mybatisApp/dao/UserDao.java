package org.mybatisApp.dao;

import org.mybatisApp.model.User;

import java.util.ArrayList;

public interface UserDao {
    User getUserById(int id);
    int insertUser(User user);
    int insertBatchUser(ArrayList<User> list);
}
