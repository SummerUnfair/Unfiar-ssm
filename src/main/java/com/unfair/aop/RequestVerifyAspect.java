package com.unfair.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author fenghao
 * @date
 * @discription
 */
@Aspect
@Component
public class RequestVerifyAspect {

    public static final Logger logger = LoggerFactory.getLogger(RequestVerifyAspect.class);

    @Pointcut("execution(public * *(..)) && @annotation(com.unfair.annotation.RequestVerify)")
    public void point() {

    }

    @Around("point()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        logger.info("请求参数:<{}>", JSONObject.toJSONString(args[0]));
        pjp.proceed();
        logger.info("=================结束请求<{}>==================");
    }
}
