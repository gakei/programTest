package com.dao;

import com.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserDao {
    @Autowired
    private SqlSession sqlSession;

    @Inject
    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserDao() {
    }

    public User selectUser(String name, String psw){
        HashMap<String, String> map=new HashMap<>();
        map.put("name", name);
        map.put("psw", psw);
        User selectedUser = sqlSession.selectOne("selectUser", map);
        return selectedUser;
    }
}
