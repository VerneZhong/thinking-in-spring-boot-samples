package com.zxb.thinking.in.spring.boot.samples.spring3.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 多层次{@link @Component @Component}派生注解 引导类
 * <p>
 * 读者调整本工程 pom.xml 文件中 spring.version 属性切换不同的 Spring Framework 版本，
 * 体验不同的多层次 {@link @Component @Component} "派生性"的运行结果
 * <ul>
 * <li>当 Spring Framework 版本小于 4.0 时，运行结果分别为：<code>true</code> 和 <code>false</code></li>
 * <li>当 Spring Framework 版本等于或大于 4.0 时，运行结果分别为：<code>true</code> 和 <code>true</code></li>
 * </ul>
 * <p>
 * @author Mr.zxb
 * @date 2020-01-06 15:09
 */
public class HierarchicalDerivedComponentAnnotationBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/context.xml");

        // 检验 myFirstLevelRepository 以及 mySecondLevelRepository 是否存在
        System.out.println("myFirstLevelRepository Bean 是否存在：" + context.containsBean("myFirstLevelRepository"));
        System.out.println("mySecondLevelRepository Bean 是否存在：" + context.containsBean("mySecondLevelRepository"));

        context.close();
    }
}
