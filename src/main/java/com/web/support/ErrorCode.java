package com.web.support;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS(200, "成功"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_REQUEST(400, "请求参数错误"),


    BIZ_ERROR(1002, "业务错误码");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}