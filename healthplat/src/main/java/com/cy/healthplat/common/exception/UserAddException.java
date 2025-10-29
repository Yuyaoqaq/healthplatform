package com.cy.healthplat.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserAddException extends RuntimeException{
    private Integer code;
    private String msg;
    // 构造方法2：包含异常原因（用于封装底层异常，如数据库异常）
    public UserAddException(Integer code, String message, Throwable cause) {
        super(cause); // 传递底层异常到 RuntimeException
        this.code = code;
        this.msg = message;
    }
}
