package org.mybatisApp.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatisApp.model.User;

import java.io.IOException;
import java.io.InputStream;

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
        int id = 1;
        UserDao dao = new UserDaoImpl(getSqlSessionFactory());
        User user = dao.getUserById(id);
        System.out.println(user);
    }

    @Test
    public void insertUser() throws IOException {
        User user = new User();
        user.setName("小A");
        user.setAge(18);
        user.setDepartmentId(2);
        user.setPhone("13763597288");
        user.setSalary(2000.00);
        UserDao dao = new UserDaoImpl(getSqlSessionFactory());
        int id = dao.insertUser(user);
        System.out.println("id: " + id);

    }
}