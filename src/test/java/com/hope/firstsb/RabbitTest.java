package com.hope.firstsb;

import com.hope.firstsb.mq.producer.Producer01;
import com.hope.firstsb.mq.producer.Producer02;
import com.hope.firstsb.mq.producer.Producer03;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RabbitTest {
    @Resource
    private Producer01 producer01;
    @Resource
    private Producer02 producer02;
    @Resource
    private Producer03 producer03;
    @Test
    public void test01() {
        int i = 0;
        while (i < 100) {
            producer01.send(i);
            producer02.send(i);
            i ++;
        }
    }

    @Test
    public void test02() {
//        producer03.send();
        System.out.println(System.currentTimeMillis());
    }
}
