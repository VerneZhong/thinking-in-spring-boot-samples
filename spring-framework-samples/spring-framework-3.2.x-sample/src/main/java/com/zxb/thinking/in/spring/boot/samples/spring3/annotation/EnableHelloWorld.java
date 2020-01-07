package com.zxb.thinking.in.spring.boot.samples.spring3.annotation;

import com.zxb.thinking.in.spring.boot.samples.spring3.config.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * HelloWorld 模块激活模式 Annotation class
 *
 * @author Mr.zxb
 * @date 2020-01-06 15:56
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(HelloWorldConfiguration.class) // 导入 HelloWorldConfiguration
public @interface EnableHelloWorld {
}
