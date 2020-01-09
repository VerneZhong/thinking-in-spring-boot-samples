package com.zxb.thinking.in.spring.boot.samples.spring5.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * {@link Transactional @Transactional} 和 {@link Service @Service} 组合注解 annotation
 *
 * @author Mr.zxb
 * @date 2020-01-08 16:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional
@Service("transactionalService")
public @interface TransactionalService {

    /**
     * 服务Bean名称
     * @return
     */
    String name() default "";
}
