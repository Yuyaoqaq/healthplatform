package com.cy.healthplat.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRoleChangeException extends RuntimeException{
    private Integer code;
    private String msg;
    public UserRoleChangeException(Integer code, String message, Throwable cause) {
        super(cause); // 传递底层异常到 RuntimeException
        this.code = code;
        this.msg = message;
    }
}
