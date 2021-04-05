package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean register(String user_name, String user_password) {
        boolean ru = userMapper.register(user_name,user_password);
        return ru;
    }

    @Override
    public boolean findByUserName(String username) {
        boolean tf = false;
//        boolean um = usersMapper.findUserName(username);
//        if(um == true ){
//            tf = false;
//        }else{tf = true;}
        return tf;
    }

}
