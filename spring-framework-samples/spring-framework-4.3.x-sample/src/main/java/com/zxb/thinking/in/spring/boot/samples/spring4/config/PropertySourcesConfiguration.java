package com.zxb.thinking.in.spring.boot.samples.spring4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.lang.annotation.Repeatable;

/**
 * 不支持 {@link Repeatable @Repeatable} 的 {@link PropertySources @PropertySources} 配置类 class
 * <p>
 * < Java 8
 *
 * @author Mr.zxb
 * @date 2020-01-07 15:25
 */
@PropertySources({@PropertySource("classpath:/default.properties"),
        @PropertySource("classpath:/overview.properties")})
@Configuration
public class PropertySourcesConfiguration {
}
