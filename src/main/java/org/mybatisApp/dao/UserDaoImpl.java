package org.mybatisApp.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatisApp.model.User;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User getUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserById(id);
            return user;
        } finally {
            sqlSession.close();
        }
    }

    public int insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int rows = mapper.insertUser(user);
            sqlSession.commit();
            return rows;
        } finally {
            sqlSession.close();
        }
    }

    public int insertBatchUser(ArrayList<User> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int rows = mapper.insertBatchUser(list);
            sqlSession.commit();
            return rows;
        } finally {
            sqlSession.close();
        }
    }
}
