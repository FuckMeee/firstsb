package com.hope.firstsb.support;

public class Response2<T> {
    private int code;
    private String msg;
    private T data;

    private Response2() {
    }

    private Response2(ResponseCode rc, T data) {
        this.code = rc.getCode();
        this.msg = rc.getMsg();
        this.data = data;
    }

    private Response2(ResponseCode rc, T data, String msg) {
        this.code = rc.getCode();
        this.msg = msg;
        this.data = data;
    }

    private Response2(ResponseCode rc) {
        this.code = rc.getCode();
        this.msg = rc.getMsg();
        this.data = data;
    }

    private Response2(ResponseCode rc, String msg) {
        this.code = rc.getCode();
        this.msg = msg;
        this.data = data;
    }

    private Response2(ResponseCode rc, String msg, T data) {
        this.code = rc.getCode();
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response2<T> success(T data) {
        return new Response2<T>(ResponseCode.SUCCESS, data);
    }

    public static <T> Response2<T> success(T data, String msg) {
        return new Response2<T>(ResponseCode.SUCCESS, data, msg);
    }

    public static <T> Response2<T> fail() {
        return new Response2<T>(ResponseCode.FAIL);
    }

    public static <T> Response2<T> fail(String msg) {
        return new Response2<T>(ResponseCode.FAIL, msg);
    }

    public static <T> Response2<T> fail(String msg, T data) {
        return new Response2<T>();
    }

    public static <T> Response2<T> common(String msg, T data) {
        return new Response2<T>();
    }
}
