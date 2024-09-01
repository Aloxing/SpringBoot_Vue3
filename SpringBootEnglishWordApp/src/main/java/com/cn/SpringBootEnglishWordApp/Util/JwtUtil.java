package com.cn.SpringBootEnglishWordApp.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.auth0.jwt.JWTVerifier;
import java.util.ArrayList;


@Component
public class JwtUtil {
    /**
     * 加密token.
     */
    @Value("${token.secretKey}")
    private String secretKey;

    public String getToken(String username, String password,Integer id) {
        //这个是放到负载payLoad 里面,魔法值可以使用常量类进行封装.
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTime = currentTimeMillis + (12*60*60*1000); // 1小时后过期
        String token = JWT
                .create()
                .withClaim("username" ,username)
                .withClaim("password", password)
                .withClaim("id", id)
                .withExpiresAt(new Date(expirationTime))
                .sign(Algorithm.HMAC256(secretKey));
        return token;
    }
    /**
     * 解析token.
     * {
     * "userId": "weizhong",
     * "userRole": "ROLE_ADMIN",
     * "timeStamp": "134143214"
     * }
     */
    public List<User> parseToken(String token) {

        //HashMap<String, String> map = new HashMap<String, String>();
        List<User> list = new ArrayList<>();
        User user = new User();
        DecodedJWT decodedjwt = JWT.require(Algorithm.HMAC256(secretKey))
                .build().verify(token);
        Claim userId = decodedjwt.getClaim("username");
        Claim userRole = decodedjwt.getClaim("password");
        Claim ID = decodedjwt.getClaim("id");

        user.setUsername(userId.asString());
        user.setPassword(userRole.asString());
        user.setId(ID.asInt());

        // map.put("usernmae", userId.asString());
        // map.put("password", userRole.asString());
        // map.put("timeStamp", timeStamp.asLong().toString());

        list.add(user);

        return list;
    }

    public boolean trueToken(String token){
        try{
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
}
