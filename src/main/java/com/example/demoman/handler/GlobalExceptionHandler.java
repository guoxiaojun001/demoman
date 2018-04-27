package com.example.demoman.handler;

import com.example.demoman.exception.MyException;
import com.example.demoman.module.ReturnResult;
import com.example.demoman.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ReturnResult handler(Exception e){
        if(e instanceof  MyException){
            MyException myException = (MyException) e;
            return ResultUtils.error(myException.getCode(),myException.getMessage());
        }else {
            logger.info("[系统异常] = {}" , e);
            return ResultUtils.error(-1,"未知错误");
        }

    }
}
