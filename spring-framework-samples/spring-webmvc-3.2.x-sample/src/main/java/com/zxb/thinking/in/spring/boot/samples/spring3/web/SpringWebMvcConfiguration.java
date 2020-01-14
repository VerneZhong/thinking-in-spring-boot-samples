package com.zxb.thinking.in.spring.boot.samples.spring3.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring Web MVC 配置
 *
 * @author Mr.zxb
 * @date 2020-01-14 17:05
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = SpringWebMvcConfiguration.class)
public class SpringWebMvcConfiguration {

}
