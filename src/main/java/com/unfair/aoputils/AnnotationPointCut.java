package com.unfair.aoputils;

import com.unfair.api.dto.LoginInfoDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author fenghao
 * @date
 * @discription
 */
//标注这个类是一个切面
@Aspect
@Component
public class AnnotationPointCut {

    public static final Logger logger = LoggerFactory.getLogger(AnnotationPointCut.class);

//    @Before("execution(* com.unfair.service.impl.*.*(..))")
//    public void before() {
//        logger.info("=================开始请求<{}>==================");
//    }
//
    @After("execution(* com.unfair.service.impl.*.*(..))")
    public void after() {
        logger.info("=================结束请求<{}>==================");
    }

    //在环绕增强中，可以给定一个参数，代表要获取处理切入的点
    @Around("execution(String com.unfair.service.impl.*.*(com.unfair.api.dto.LoginInfoDTO,..)) && args(dto,a)")
    public String around(ProceedingJoinPoint jp , LoginInfoDTO dto,String a) throws Throwable {
        System.out.println("ferao aop around1 anntation success ..");

        //unfair
        System.out.println(a);
        //执行被环绕通知封装的切入方法
        Object proceed = jp.proceed();
        System.out.println("proceed content :" +proceed);//proceed content :原方法返回

        //获得访问该方法的参数内容，默认是数组，即入参是多个
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            //args content :LoginInfoDTO{username='username', password='password'}
            //args content :unfair
            System.out.println("args content :" +arg);
        }

        //获取签名，即：全路径.类名.方法(参数类型名)
        Signature signature = jp.getSignature();
        //signature content :String com.unfair.service.LoginService.checkUserInfo(LoginInfoDTO,String)
        System.out.println("signature content :" +signature);

        if (dto == null){
            System.out.println("参数为空");
            System.out.println("ferao aop around2 anntation success ..");
            return "aop为空返回";
        }else{
            System.out.println("参数不为空");
            System.out.println(dto);
            System.out.println("ferao aop around3 anntation success ..");
            return "aop不为空返回";
        }
    }
}
