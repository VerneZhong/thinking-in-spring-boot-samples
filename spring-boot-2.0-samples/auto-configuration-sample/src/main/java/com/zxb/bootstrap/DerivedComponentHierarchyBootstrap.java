package com.zxb.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-08 15:02
 */
@SpringBootApplication
public class DerivedComponentHierarchyBootstrap {

    public static void main(String[] args) {
        // 当前引导类
        Class<DerivedComponentHierarchyBootstrap> bootstrapClass =
                DerivedComponentHierarchyBootstrap.class;

        // 运行Spring Boot，并返回Spring应用上下文
        ConfigurableApplicationContext context = new SpringApplicationBuilder(bootstrapClass)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("当前引导类Bean：" + context.getBean(bootstrapClass));

        // 关闭上下文
        context.close();
    }
}
