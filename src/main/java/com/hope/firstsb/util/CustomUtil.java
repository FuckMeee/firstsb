package com.hope.firstsb.util;

import java.util.Date;

public class CustomUtil {
    public static String createTradeNo() {
        return DateUtil.format(new Date(), DateUtil.DATE_WITHOUT_COLON) + (int)(Math.random() * 100000000);
    }
}
