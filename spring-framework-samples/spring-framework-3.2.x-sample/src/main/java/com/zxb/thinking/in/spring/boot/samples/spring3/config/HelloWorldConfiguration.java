package com.zxb.thinking.in.spring.boot.samples.spring3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-06 15:50
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() { // 创建名为"helloWorld" String 类型的Bean
        return "Hello World";
    }
}
