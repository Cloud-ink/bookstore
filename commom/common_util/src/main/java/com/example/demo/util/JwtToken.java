package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.*;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

public class JwtToken {
    //过期时间
    public static final long EXPIRE = 1000 * 60 * 60;
    //app secret
    public static final String SECREST = "acnviaerbvpbercdve23r2fw";

    @ApiOperation("生成key，对原始key进行加密")
    public static Key getKeyInstance() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;//选择加密算法
        byte[] bytes = DatatypeConverter.parseBase64Binary(SECREST);
        return new SecretKeySpec(bytes, signatureAlgorithm.getJcaName());//生成这个对象，是key接口的实现类，key类型对象，
    }

    public static String getJwtToken(JwtInfo jwtInfo, int expire) {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("bookstore")//主题
                .setIssuedAt(new Date())//颁发时间
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())//过期时间,在当前时间加上一些秒数，不是毫秒
                .claim("id", jwtInfo.getId())
                .claim("username", jwtInfo.getUsername())
                .claim("avatar", jwtInfo.getAvatar())
                .signWith(SignatureAlgorithm.HS256, getKeyInstance())//再次加密
                .compact();
        return JwtToken;
    }

    //判断token是否存在与有效
    public static boolean checkJwtToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {//如果解析失败，抛出异常并返回false
            Jwts.parser().setSigningKey(getKeyInstance())
                    .parseClaimsJws(jwtToken);//解析
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //校验重载,从request获取
    public static boolean checkJwtToken(HttpServletRequest request) {
        try {//如果解析失败，抛出异常并返回false
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(getKeyInstance())
                    .parseClaimsJws(jwtToken);//解析
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    //解析jwt
    public static JwtInfo getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        System.out.println(jwtToken);
        if (StringUtils.isEmpty(jwtToken)) return null;

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwtToken);//解析
        Claims claims = claimsJws.getBody();
        JwtInfo jwtInfo = new JwtInfo(
                (claims.get("id").toString()),
                 claims.get("username").toString(),
                 claims.get("avatar").toString());
        return jwtInfo;

    }
}
