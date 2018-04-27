package com.example.demoman.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


//@Aspect
//@Component
public class HttpAspect {

    //拦截特定的方法
    //@Before("execution(public * com.example.demoman.controller.ManController.add( ..))")

    @Before("execution(public * com.example.demoman.controller.ManController.*( ..))")
    public void logBefore(){

        System.out.println("--------aop 先拦截------");
    }


    @After("execution(public * com.example.demoman.controller.ManController.*( ..))")
    public void logAfter(){

        System.out.println("--------aop 后拦截------");
    }

}
