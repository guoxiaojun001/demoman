package com.example.demoman.errorenum;


/**
 * 所有错误码 统一管理地方
 */
public enum ErrorCodeEnum {

    UNKONW_ERROR(-1,"未知错误"),
    ERROR_100(100,"100错误"),
    ERROR_200(200,"200错误"),
    SUCCESS(0,"成功"),
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ErrorCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;

    }
}
