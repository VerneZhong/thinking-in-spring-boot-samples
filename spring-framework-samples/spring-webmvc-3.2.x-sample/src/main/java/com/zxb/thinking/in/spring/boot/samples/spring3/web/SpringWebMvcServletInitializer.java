package com.zxb.thinking.in.spring.boot.samples.spring3.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC {@link WebApplicationInitializer} 实现
 *
 * @author Mr.zxb
 * @date 2020-01-14 17:07
 */
public class SpringWebMvcServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * DispatcherServlet 配置 Bean
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return of(SpringWebMvcConfiguration.class);
    }

    /**
     * DispatcherServlet URL Pattern 映射
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return of("/*");
    }

    /**
     * 构建泛型数组，减少new T[] 代码
     * @param args
     * @param <T>
     * @return
     */
    private static <T> T[] of(T... args) {
        return args;
    }
}
