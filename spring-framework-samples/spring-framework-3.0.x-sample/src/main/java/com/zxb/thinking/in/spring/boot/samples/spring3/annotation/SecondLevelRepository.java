package com.zxb.thinking.in.spring.boot.samples.spring3.annotation;

import java.lang.annotation.*;

/**
 * 二级 {@link @Repository @Repository} annotation
 *
 * @author Mr.zxb
 * @date 2020-01-06 15:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
