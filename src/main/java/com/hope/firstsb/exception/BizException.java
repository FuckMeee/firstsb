package com.hope.firstsb.exception;

import lombok.Getter;
import lombok.Setter;

public class BizException extends RuntimeException {
    @Getter
    @Setter
    private int code;

    public BizException() {
        super();
    }

    public BizException(int code, String message) {
        super(message);
        this.setCode(code);
    }
}
