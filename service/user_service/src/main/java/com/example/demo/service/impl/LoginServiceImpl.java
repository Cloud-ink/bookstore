package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.exception.BookStoreException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.vo.LoginVo;
import com.example.demo.result.JwtUtil;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.LoginService;
import com.example.demo.util.JwtInfo;
import com.example.demo.util.JwtToken;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.joda.time.format.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

//    @Override
//    public boolean register(String user_name, String user_password) {
//        boolean ru = userMapper.register(user_name,user_password);
//        return ru;
//    }
//
//    @Override
//    public boolean findByUserName(String username) {
//        boolean tf = false;
////        boolean um = usersMapper.findUserName(username);
////        if(um == true ){
////            tf = false;
////        }else{tf = true;}
//        return tf;
//    }
    //登录

    @Override
    public String login(LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        //校验：参数是否合法
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new BookStoreException(ResultCodeEnum.FAILED);
        }
        //校验用户名是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null) {
            throw new BookStoreException(ResultCodeEnum.LOGIN_ERROR);
        }
        //校验密码是否正确

        //用户是否被禁用

        //登录：生成token
        JwtInfo info = new JwtInfo();
        info.setId(user.getUserId());
        info.setUsername(user.getUserName());
        info.setAvatar(user.getUserEmail());

        String token = JwtToken.getJwtToken(info,1800);
        return token;
    }

}
