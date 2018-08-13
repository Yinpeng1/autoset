package com.yp.autoset.annotation;


import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Yinpeng {

    String value() default "hello";
}
