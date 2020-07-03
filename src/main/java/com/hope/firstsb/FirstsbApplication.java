package com.hope.firstsb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hope.firstsb.dao")
public class FirstsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstsbApplication.class, args);
    }
}
