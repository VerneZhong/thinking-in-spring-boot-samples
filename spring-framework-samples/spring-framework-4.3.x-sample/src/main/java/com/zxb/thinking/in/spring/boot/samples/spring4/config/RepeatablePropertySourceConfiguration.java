package com.zxb.thinking.in.spring.boot.samples.spring4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.Repeatable;

/**
 * 支持 {@link Repeatable @Repeatable} 的 {@link PropertySource @PropertySource} 配置类
 * <p>
 * 依赖于 Java 8
 * @author Mr.zxb
 * @date 2020-01-07 15:29
 */
@PropertySource("classpath:/default.properties")
@PropertySource("classpath:/overview.properties")
@Configuration
public class RepeatablePropertySourceConfiguration {
}
