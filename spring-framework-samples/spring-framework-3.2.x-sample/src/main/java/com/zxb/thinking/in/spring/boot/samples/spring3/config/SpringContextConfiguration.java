package com.zxb.thinking.in.spring.boot.samples.spring3.config;

import com.zxb.thinking.in.spring.boot.samples.spring3.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-01-06 15:34
 */
@ImportResource("classpath:/META-INF/spring/others.xml") // 替代Import
@Configuration("springContextConfiguration")
@ComponentScan(basePackages = "com.zxb.thinking.in.spring.boot.samples")  // 替代<context:component-scan base-package>
@Profile("!production") // 非生产环境
public class SpringContextConfiguration {

    /**
     * @return
     */
    @Lazy
    @Primary
    // 依赖 springContextConfiguration
    @DependsOn("springContextConfiguration")
    // Bean的名称为user
    @Bean(name = "user")
    @Role(BeanDefinition.ROLE_APPLICATION) // 应用角色
    public User user() {
        User user = new User();
        user.setName("钟学斌");
        return user;
    }
}
