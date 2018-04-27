package com.example.demoman.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect2 {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect2.class);

    //推荐此种方法
    @Pointcut("execution(public * com.example.demoman.controller.ManController.*( ..))")
    public void log(){

    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        logger.info("---HttpAspect2-----aop 先拦截------");
        /**
         *  获取请求信息
         *      1.url
         *      2.method
         *      3.ip
         *      4.类 方法
         *      5.参数
         */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest httpServletRequest = attributes.getRequest();
        //1.url
        logger.info("url = {}",httpServletRequest.getRequestURL());
        //2.method
        logger.info("method = {}",httpServletRequest.getMethod());
        // 3.ip
        logger.info("ip = {}",httpServletRequest.getRemoteAddr());
        //4.类 方法
        logger.info("class_method = {}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //5.参数
        logger.info("args = {}",joinPoint.getArgs());
    }


    @After("log()")
    public void logAfter(){
        logger.info("---HttpAspect2-----aop 后拦截------");
    }


    @AfterReturning(returning = "object",pointcut = "log()")
    private void afterReturning(Object object){
        //可以获取 接口返回值
        logger.info("AfterReturning response={}",object);
    }

}
