package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JWTUtils {
    //过期时间
    public  static final long EXPIRE = 1000*60*60;
    //app secret
    public static final String SECREST = "lalala";

    public static String genJwt(String userName,String userPassword,int userPhone){
        //头部信息
        HashMap<String,Object> header = new HashMap<>();
        header.put("alg","HS256");//签名算法
        header.put("typ","JWT");//加密算法
        //签名hash
        Algorithm algorithm = Algorithm.HMAC256(SECREST);

        String token = JWT.create()
                //第一部分：头部信息
                .withHeader(header)
                //第二部分：有效载荷
                //默认字段
                .withJWTId("1")//jwt的唯一身份认证，一次性令牌，从而回避重放攻击
                .withIssuer("bookstore")//令牌主题
                .withIssuedAt(new Date())//有效时间
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE))//过期时间
                //私有字段
                .withClaim("userName",userName)
                .withClaim("userPassword",userPassword)
                .withClaim("userPhone",userPhone)
                //第三部分：签名hash
                .sign(algorithm);
        return token;
    }

    //解析jwt
    public static DecodedJWT checkJwt(String jwtToken) {
        Algorithm algorithm = Algorithm.HMAC256(SECREST);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(jwtToken);

        return jwt;

    }
}
