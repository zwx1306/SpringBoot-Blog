package com.ecut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


//被spring托管
@Component
//aop切面
@Aspect
public class LogAspect {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    //通过pointcut来表示一个切面,execution()表示拦截哪些
    ////拦截controller下所有类和所有方法
    @Pointcut("execution(* com.ecut.controller.*.*(..))")
    public void log(){}

    @Before("log()")//传递切面log
    public void doBefore(JoinPoint joinPoint){
        //这个attributes可以获得url和ip
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //类名 . 方法名
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request: {}", requestLog);





    }
    @After("log()")
    public void doAfter(){
        logger.info("-------doafter---------");
    }
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }





}
