package com.example.demo;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.User;
import com.example.demo.util.JWTUtils;
import org.junit.Test;

public class JWTTest {
    @Test
    public void testGenJwt(){
        User user = new User();
        user.setUserName("qwe");
        user.setUserPassword("asd");
        user.setUserPhone(123);

        String token = JWTUtils.genJwt(user.getUserName(),user.getUserPassword(),user.getUserPhone());
        System.out.println(user.getUserPhone());
        System.out.println(token);
    }
    //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyUGFzc3dvcmQiOiJhc2QiLCJ1c2VyUGhvbmUiOjEyMywiaXNzIjoiYm9va3N0b3JlIiwiZXhwIjoxNjE4MjIyNTU1LCJ1c2VyTmFtZSI6InF3ZSIsImlhdCI6MTYxODIxODk1NSwianRpIjoiMSJ9.uFV5IfIx1QRTa8uAW-xTEUXBTSd3mo08OpHpM_Jx3Q8

    @Test
    public void testCheckJwt(){
        DecodedJWT token = JWTUtils.checkJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyUGFzc3dvcmQiOiJhc2QiLCJ1c2VyUGhvbmUiOjEyMywiaXNzIjoiYm9va3N0b3JlIiwiZXhwIjoxNjE4MjI0NTk3LCJ1c2VyTmFtZSI6InF3ZSIsImlhdCI6MTYxODIyMDk5NywianRpIjoiMSJ9.z1VHMh08WTXIPQNR6VaZngv09fOId0tglbChbbt_i90");
        String userId = token.getClaim("userName").asString();
        String userpassword = token.getClaim("userPassword").asString();
        int userPhone = token.getClaim("userPhone").asInt();
        System.out.println(userId+userpassword+userPhone);
    }
}
