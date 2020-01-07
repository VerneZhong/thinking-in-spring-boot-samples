package com.zxb.thinking.in.spring.boot.samples.spring4.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 指定{@link #name() 属性名称}与{@link #value() 值} 匹配条件注解 annotation
 *
 * @author Mr.zxb
 * @date 2020-01-07 14:58
 */
// 只能标记在方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * 系统属性名称
     * @return
     */
    String name();

    /**
     * 系统属性值
     * @return
     */
    String value();
}
