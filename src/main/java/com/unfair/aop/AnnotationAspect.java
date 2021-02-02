package com.unfair.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 * @author fenghao
 * @date
 * @discription
 */
@Aspect
@Component
public class AnnotationAspect {

    public static final Logger logger = LoggerFactory.getLogger(AnnotationAspect.class);

    @Pointcut("execution(* com.unfair.service.impl.*.*(..))")
    public void point() {

    }

    // 在环绕增强中，可以给定一个参数，代表要获取处理切入的点
    @Around("execution(* com.unfair.service.impl.*.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        logger.info("=================开始请求<{}>==================");
        jp.proceed();
        logger.info("=================结束请求<{}>==================");
    }
}
