package com.hope.firstsb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class LambdaTest {
    @Test
    public void test01() {
//        new Thread(() -> System.out.println("zwh")).start();
        System.out.println("*********************************");
//        MyLambda myLambda = message -> System.out.println("Hello " + message);
//        myLambda.zwh("ddddd");
//        new MyLambda(message -> System.out.println("Hello " + message)).zwh();
//        MyLambda myLambda = new MyLambda() {
//            @Override
//            public void zwh(String message) {
//                System.out.println("Hello " + message);
//            }
//        };
//        myLambda.zwh("zwh");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.forEach(i -> System.out.println(i));
    }

    @Test
    public void test02() {
        MyLambda myLambda = (a, b) -> a + b;
        int i = myLambda.zwh(1, 2);
        System.out.println(i);
    }
}

interface MyLambda {
    int zwh(int a, int b);
}