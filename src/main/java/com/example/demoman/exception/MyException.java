package com.example.demoman.exception;


import com.example.demoman.aspect.HttpAspect2;
import com.example.demoman.errorenum.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyException extends RuntimeException {

    private Integer code;

    public MyException (ErrorCodeEnum  codeEnum ){
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
