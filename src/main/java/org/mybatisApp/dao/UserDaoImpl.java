package org.mybatisApp.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatisApp.model.User;

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
            int id = mapper.insertUser(user);
            sqlSession.commit();
            return id;
        } finally {
            sqlSession.close();
        }
    }
}
