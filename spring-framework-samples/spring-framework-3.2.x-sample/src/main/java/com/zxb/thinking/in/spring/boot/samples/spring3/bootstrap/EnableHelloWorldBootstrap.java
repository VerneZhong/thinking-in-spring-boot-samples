package com.zxb.thinking.in.spring.boot.samples.spring3.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring3.annotation.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * {@link EnableHelloWorld} 引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 15:53
 */
@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        // 构建 Annotation 配置驱动 Spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 当前引导类（被 @Configuration 标注） 到 Spring 上下文
        context.register(EnableHelloWorldBootstrap.class);
        // 启动上下文
        context.refresh();

        String helloWorld = (String) context.getBean("helloWorld");

        System.out.println(helloWorld);

        // 关闭上下文
        context.close();
    }
}
