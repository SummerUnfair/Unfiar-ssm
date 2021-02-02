package com.unfair.annotation;

import java.lang.annotation.*;

/**
 * @author fenghao
 * @version 1.0.0
 * @discription
 * @create 2020-09-05 18:43
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RequestVerify {

    boolean isVerify() default true;
}
