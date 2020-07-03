package com.hope.firstsb;

import com.hope.firstsb.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class JwtTest {
    @Test
    public void createToken() {
        System.out.println("=================================");
        Map<String, String> map = new HashMap<>();
        map.put("name", "zwh");
        map.put("age", "28");
        String token = JwtUtil.createToken(map);
        System.out.println(token);
    }

    @Test
    public void verifyToken() {
        System.out.println("=================================");
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJuYW1lIjoiendoIiwiYWdlIjoiMjgifSwiaXNzIjoiYXV0aDAiLCJleHAiOjE1OTQ5NzE1ODB9.SIoljh-UkS0jAAFp7YSUkOQoD2xEYKNjpgZsRpSTV-cd";
        JwtUtil.verifyToken(token);
    }

    @Test
    public void decodeToken() {
        System.out.println("=================================");
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6eyJuYW1lIjoiendoIiwiYWdlIjoiMjgifSwiaXNzIjoiYXV0aDAiLCJleHAiOjE1OTQ5NzE1ODB9.SIoljh-UkS0jAAFp7YSUkOQoD2xEYKNjpgZsRpSTV-cd";
        JwtUtil.decodeToken(token);
    }
}
