package com.example.demoman.utils;

import com.example.demoman.module.ReturnResult;

public class ResultUtils {

    public static ReturnResult success(Object object){
        ReturnResult result = new ReturnResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }


    public static ReturnResult success(){
        return ResultUtils.success(null);
    }


    public static ReturnResult error(Integer code,String msg){
        ReturnResult result = new ReturnResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
