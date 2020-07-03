package com.hope.firstsb.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    public static String createToken(Map<String, String> map) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create().withIssuer("auth0")
                .withExpiresAt(DateUtil.addHour(new Date(), 24 * 14))
                .withClaim("userInfo", map)
                .sign(algorithm);
        return token;
    }

    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0") // 匹配指定的token发布者 auth0
                    .build();
            // 解码JWT ，verifier 可复用
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt);
            return true;
        } catch (JWTVerificationException e) {
            // 无效的签名/声明
            System.out.println("666");
            return false;
        }
    }

    public static void decodeToken(String token) {
        DecodedJWT jwt = JWT.decode(token);

        String algorithm = jwt.getAlgorithm(); //获取算法类型
        String type = jwt.getType();    //获取token类型
        String issuer = jwt.getIssuer();    //获取token发布者
        Date expiresAt = jwt.getExpiresAt(); //获取token过期时间
        Date issuedAt = jwt.getIssuedAt();  // 获取token生产日期
        Map map = jwt.getClaim("userInfo").asMap();  // 获取token生产日


        System.out.println(algorithm);  //=>    HS256
        System.out.println(type);       //=>    JWT
        System.out.println(issuer);     //=>    auth0
        System.out.println(expiresAt);  //=>    Sat Jan 11 22:25:13 CST 2020
        System.out.println(issuedAt);   //=>    Sat Jan 11 20:25:13 CST 2020
        System.out.println(map);
    }

}
