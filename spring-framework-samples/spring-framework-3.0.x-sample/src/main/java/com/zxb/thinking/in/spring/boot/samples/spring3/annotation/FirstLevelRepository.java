package com.zxb.thinking.in.spring.boot.samples.spring3.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 一级 {@link @Repository @Repository} annotation
 *
 * @author Mr.zxb
 * @date 2020-01-06 15:02
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    String value() default "";
}
