package com.zxb.thinking.in.spring.boot.samples.spring4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * {@link ComponentScan @ComponentScan} 默认包引导类
 *
 * @author Mr.zxb
 * @date 2020-01-07 14:53
 */
@ComponentScan(basePackageClasses = DefaultPackageBootstrap.class)
public class DefaultPackageBootstrap {

    public static void main(String[] args) {
        // 注册当前类为配置class，并启动上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DefaultPackageBootstrap.class);

        // 输出当前 Spring 应用上下文中所有注册的 Bean 名称
        System.out.println("当前 Spring 应用上下文中所有注册的 Bean 名称：");
        Arrays.stream(context.getBeanDefinitionNames())
                .map(name -> "\t" + name)
                .forEach(System.out::println);

        // 关闭上下文
        context.close();
    }
}
