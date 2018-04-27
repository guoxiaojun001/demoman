package com.example.demoman.module;


//统一数据返回格式
public class ReturnResult<T> {

    //返回码
    private Integer code;
    //提示信息
    private String msg;
    //数据对象
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
