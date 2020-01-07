package com.zxb.thinking.in.spring.boot.samples.spring4.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解{@link Lookup} 引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 15:59
 */
@Configuration
public class AnnotationLookupBootstrap {

    @Lookup("helloWorld") // 依赖查找
    @Bean("helloWorld")
    public String helloWorld() {
        return "Hello World";
    }

    @Autowired
    @Qualifier("helloWorld") // 依赖查找
    private String helloWorld;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 AnnotationLookupBootstrap Configuration Class
        context.register(AnnotationLookupBootstrap.class);
        // 启动上下文
        context.refresh();
        System.out.printf("helloWorld Bean : %s\n", context.getBean("helloWorld"));

        AnnotationLookupBootstrap bootstrap = context.getBean(AnnotationLookupBootstrap.class);
        System.out.println("bootstrap = " + bootstrap.helloWorld);

        // 关闭上下文
        context.close();
    }

}
