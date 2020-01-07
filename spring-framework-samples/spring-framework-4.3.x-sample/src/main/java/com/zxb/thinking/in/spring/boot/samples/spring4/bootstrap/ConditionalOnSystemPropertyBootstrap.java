package com.zxb.thinking.in.spring.boot.samples.spring4.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring4.annotation.ConditionalOnSystemProperty;
import com.zxb.thinking.in.spring.boot.samples.spring4.config.ConditionalMessageConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;

/**
 * {@link Conditional} 之 {@link ConditionalOnSystemProperty} 条件装配引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 15:08
 */
public class ConditionalOnSystemPropertyBootstrap {

    public static void main(String[] args) {
        // 设置 System Property  language = Chinese
        System.setProperty("language", "English");

        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册 配置Bean ConditionalMessageConfiguration 到 Spring 上下文
        context.register(ConditionalMessageConfiguration.class);
        // 启动上下文
        context.refresh();

        String message = (String) context.getBean("message");

        System.out.println(message);

        context.close();
    }
}
