package com.zxb.thinking.in.spring.boot.samples.spring4.bootstrap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;


/**
 * {@link ComponentScan @ComponentScan} 默认包引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 15:42
 */
@ComponentScan(basePackages = "")    // 扫描默认包
//@ComponentScan(basePackages = "org.springframework")   // 扫描 Spring Framework 根包
public class ComponentScanDefaultPackageBootstrap {

    public static void main(String[] args) {
        // 注册当前引导类作为配置class，并启动当前上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanDefaultPackageBootstrap.class);
        // 输出当前 Spring 应用上下文中所有注册的 Bean 名称
        System.out.println("当前 Spring 应用上下文中所有注册的 Bean 名称：");
        Stream.of(context.getBeanDefinitionNames()).map(name -> "\t" + name)
                .forEach(System.out::println);
        // 关闭上下文
        context.close();
    }
}
