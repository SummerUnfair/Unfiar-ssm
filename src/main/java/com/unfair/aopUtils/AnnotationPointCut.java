package com.unfair.aopUtils;/*
 * @author Ferao
 * @date
 * @discription
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect//标注这个类是一个切面
@Component
public class AnnotationPointCut {

    @Before("execution(* com.unfair.service.ServiceImpl.*.*(..))")
    public void before(){
        System.out.println("ferao aop before anntation success ..");
    }
    @After("execution(* com.unfair.service.ServiceImpl.*.*(..))")
    public void after(){
        System.out.println("ferao aop after anntation success ..");
    }
    //在环绕增强中，可以给定一个参数，代表要获取处理切入的点
    @Around("execution(* com.unfair.service.ServiceImpl.*.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("ferao aop around1 anntation success ..");
        Signature signature = jp.getSignature(); //获取签名
        System.out.println(signature);
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("ferao aop around2 anntation success ..");
        System.out.println(proceed);
    }
}
