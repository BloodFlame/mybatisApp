package org.mybatisApp.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatisApp.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UserDaoImplTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    };

    @org.junit.Test
    public void getUserById() throws IOException {
        int id = 5;
        UserDao dao = new UserDaoImpl(getSqlSessionFactory());
        User user = dao.getUserById(id);
        System.out.println(user);
    }

    @Test
    public void insertUser() throws IOException {
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        User user = new User();
        user.setName("小A");
        user.setAge(18);
        user.setDepartmentId(2);
        user.setPhone("13763597288");
        user.setSalary(2001.00);
        UserDao dao = new UserDaoImpl(getSqlSessionFactory());
        int rows = dao.insertUser(user);
        System.out.println("id: " + user.getId() + " rows: " + rows);
    }

    @Test
    public void insertBatchUser() throws IOException {
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        ArrayList<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("小A"+i);
            user.setAge(18);
            user.setDepartmentId(2);
            user.setPhone("13763597288");
            user.setSalary(2001.00);
            list.add(user);
        }
        UserDao dao = new UserDaoImpl(getSqlSessionFactory());
        int rows = dao.insertBatchUser(list);
        for (User u : list) {
            System.out.println("id: " + u.getId() + " rows: " + rows);
        }
    }
}