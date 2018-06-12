package com.sym.springboot.rest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: Song Yimin
 * @description:
 * @date: 2018/6/12
 */
@Aspect
@Component
public class CtrlAspect {

    private static Logger logger = LoggerFactory.getLogger(CtrlAspect.class);

    @Pointcut("execution(public * com.sym.springboot.rest.controller.*.*(..))")
    public void log(){};

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doAfterRetruning(Object ret){
        System.out.println("方法的返回值:"+ret);
    }

    @After("log()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }

}
