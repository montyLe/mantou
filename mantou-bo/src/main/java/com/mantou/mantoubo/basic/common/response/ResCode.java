package com.mantou.mantoubo.basic.common.response;

import lombok.Getter;

/**
 * @author lm
 * @title: ResCode
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:28
 */
@Getter
public enum ResCode {
    // 系统错误码
    SUCCESS(true,0,"成功!"),
    FAIL(false,1,"失败!"),
    ERROR(false,-1,"系统错误!"),
    UNKNOWN_REASON(false,1001,"未知错误")

    ;

    private Boolean success;

    private Integer code;

    private String message;

    ResCode(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
