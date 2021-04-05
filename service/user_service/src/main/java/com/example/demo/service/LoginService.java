package com.example.demo.service;

public interface LoginService {
    //用户名是否已注册Result
    public boolean findByUserName(String username);
    //注册
    boolean register(String user_name,String user_password);
}
