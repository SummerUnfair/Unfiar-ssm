package com.unfair.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author fenghao
 * @version 1.0.0
 * @discription
 * @create 2020-09-05 18:43
 */
@Order(1)
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiAnnotation {

    String desc();
}
