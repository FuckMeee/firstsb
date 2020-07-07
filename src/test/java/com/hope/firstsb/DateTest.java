package com.hope.firstsb;

import com.hope.firstsb.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class DateTest {
    @Test
    public void test01() {
        System.out.println(DateUtil.format(new Date(), DateUtil.DATE_WITHOUT_COLON));
    }
}
