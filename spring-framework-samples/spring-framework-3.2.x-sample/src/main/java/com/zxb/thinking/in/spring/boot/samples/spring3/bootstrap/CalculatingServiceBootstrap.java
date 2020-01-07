package com.zxb.thinking.in.spring.boot.samples.spring3.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring3.service.CalculatingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

/**
 * {@link CalculatingService} 引导程序 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 09:41
 */
@Configuration
@ComponentScan(basePackageClasses = CalculatingService.class)
public class CalculatingServiceBootstrap {

    static {
        // 通过 Java 系统属性设置 Spring Profile
        // 以下语句等效于 ConfigurableEnvironment.setActiveProfiles("Java8")
//        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "Java8");

        // 以下语句等效于 ConfigurableEnvironment.setDefaultProfiles("Java7")
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "Java7");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatingServiceBootstrap.class);

        CalculatingService service = context.getBean(CalculatingService.class);

        service.sum(1, 2, 3, 4, 5);

        context.close();
    }
}
