package com.hope.firstsb.support;

/**
 * @author zwh
 */
public enum ResponseCode {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    UNAUTHORIZED(11, "未授权"),
    FORBIDDEN(12, "没有权限"),
    UNSUBSCRIBE(13, "未关注");


    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
