package com.unfair.aop;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author fenghao
 * @discription
 * @create 2020-09-05 18:43
 */
@Order(1)
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiAnnotation {

    String code() default "200";

    String desc();
}
