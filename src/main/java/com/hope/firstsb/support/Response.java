package com.hope.firstsb.support;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zwh
 */

@Getter
@Setter
public class Response<T> {
    private int code;           // 状态码
    private String msg;         // 信息
    private T data;             // 数据

    /**
     * @param rc ResponseCode
     */
    private Response(ResponseCode rc) {
        this.code = rc.getCode();
        this.msg = rc.getMsg();
    }

    /**
     * @param code int
     * @param msg  String
     */
    private Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 添加返回信息
     *
     * @param msg String
     */
    public Response<T> addMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 添加返回数据
     *
     * @param data T
     */
    public Response<T> addData(T data) {
        this.data = data;
        return this;
    }


    /**
     * 成功返回，ResponseCode枚举类型默认SUCCESS
     */
    public static <T> Response<T> success() {
        return new Response<>(ResponseCode.SUCCESS);
    }

    /**
     * 失败返回，ResponseCode枚举类型默认FAIL
     */
    public static <T> Response<T> fail() {
        return new Response<>(ResponseCode.FAIL);
    }

    /**
     * 通用返回，ResponseCode枚举类型可选
     *
     * @param rc ResponseCode
     */
    public static <T> Response<T> common(ResponseCode rc) {
        return new Response<>(rc);
    }

    /**
     * 异常返回，直接入参code和msg
     *
     * @param code int
     * @param msg  String
     */
    public static <T> Response<T> exception(int code, String msg) {
        return new Response<>(code, msg);
    }
}
