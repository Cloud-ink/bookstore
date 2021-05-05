package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.vo.LoginVo;

public interface LoginService {
    //用户名是否已注册Result
//    boolean findByUserName(String username);
    //注册
//    boolean register(String user_name,String user_password);
    //登录
    String login(LoginVo loginVo);
}
