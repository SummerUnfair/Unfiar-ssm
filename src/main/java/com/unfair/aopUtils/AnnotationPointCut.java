package com.unfair.aopUtils;/*
 * @author Ferao
 * @date
 * @discription
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect//标注这个类是一个切面
@Component
public class AnnotationPointCut {

    public static final Logger logger = LoggerFactory.getLogger(AnnotationPointCut.class);

    @Before("execution(* com.unfair.service.impl.*.*(..))")
    public void before(){
        logger.info("=================开始请求<{}>==================");
    }

    @After("execution(* com.unfair.service.impl.*.*(..))")
    public void after(){
        logger.info("=================结束请求<{}>==================");
    }
    //在环绕增强中，可以给定一个参数，代表要获取处理切入的点
//    @Around("execution(* com.unfair.service.impl.*.*(..))")
//    public void around(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("ferao aop around1 anntation success ..");
//        Signature signature = jp.getSignature(); //获取签名
//        System.out.println(signature);
//        //执行方法
//        Object proceed = jp.proceed();
//        System.out.println("ferao aop around2 anntation success ..");
//        System.out.println(proceed);
//    }
}
