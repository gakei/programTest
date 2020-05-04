package com.controller;

import com.dao.UserDao;
import com.entity.User;
import com.result.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RestController
public class loginController {
    @Autowired
    UserDao userDao;

    @Inject
    public loginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultDTO hello(@RequestBody Map<String, String> user){
        String name = (String) user.get("name");
        String psw = (String) user.get("psw");
        if (userDao==null)
            return null;
        User user1 = userDao.selectUser(name, psw);
        if (user1==null){
            return new ResultDTO("用户名或密码错误", 404);
        }
        if (user1!=null){
            return new ResultDTO("登录成功", 200);
        }
        return new ResultDTO("未知错误", 404);
    }
}
