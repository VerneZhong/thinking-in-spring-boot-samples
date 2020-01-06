package com.zxb.thinking.in.spring.boot.samples.spring25.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * String 类型仓储，模仿{@link @Repository}，派生于 {@link Component} annotation
 *
 * @author Mr.zxb
 * @date 2020-01-06 14:26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component // 测试多层次 @Component派生，请将当前注释
//@Repository // 测试多层次 @Component派生，请将当前反注释，并且将 spring-context 升级到 3.0.0.RELEASE
public @interface StringRepository {

    /**
     * 属性方法必须与 {@link Component#value()} 保持一致
     * @return
     */
    String value() default "";
}
