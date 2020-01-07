package com.zxb.thinking.in.spring.boot.samples.spring4.config;

import com.zxb.thinking.in.spring.boot.samples.spring4.annotation.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 条件消息装配 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 15:10
 */
@Configuration
public class ConditionalMessageConfiguration {

    /**
     * 中文消息
     * @return
     */
    @ConditionalOnSystemProperty(name = "language", value = "Chinese")
    @Bean("message")
    public String chineseMessage() {
        return "你好，世界";
    }

    /**
     * 英语消息
     * @return
     */
    @ConditionalOnSystemProperty(name = "language", value = "English")
    @Bean("message")
    public String englishMessage() {
        return "Hello World";
    }
}
