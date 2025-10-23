package com.cy.healthplat.common.util;
import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    // 枚举值
    SUCCESS(true, "操作成功", 200),
    UNKNOWN_REASON(false, "操作失败", 999),
    BAD_SQL_GRAMMAR(false, "sql语法错误", 520),
    ERROR(false, "操作失败", 444);

    private Boolean success;
    private String message;
    private Integer code;

    ResultCodeEnum(Boolean success, String message, Integer code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }
}
