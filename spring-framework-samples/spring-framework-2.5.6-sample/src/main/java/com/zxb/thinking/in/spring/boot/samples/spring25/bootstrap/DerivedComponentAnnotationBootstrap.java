package com.zxb.thinking.in.spring.boot.samples.spring25.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring25.repository.NameRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link @Component} "派生"注解 引导程序 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 14:34
 */
public class DerivedComponentAnnotationBootstrap {

    static {
        // 解决 Spring 2.5.x 不兼容 Java 8 的问题
        // 同时，请注意 Java Security 策略，必须具备 PropertyPermission
        System.setProperty("java.version", "1.7.0");
    }

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/spring/context.xml");

        NameRepository repository = (NameRepository) beanFactory.getBean("chineseNameRepository");

        // 输出 [张三, 李四, 钟学斌]
        System.out.println(repository.findAll());
    }
}
