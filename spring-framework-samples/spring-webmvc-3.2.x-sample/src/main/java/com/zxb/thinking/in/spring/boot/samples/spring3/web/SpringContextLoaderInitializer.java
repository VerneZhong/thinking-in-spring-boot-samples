package com.zxb.thinking.in.spring.boot.samples.spring3.web;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Spring {@link AbstractContextLoaderInitializer} 实现
 *
 * @author Mr.zxb
 * @date 2020-01-14 17:27
 */
public class SpringContextLoaderInitializer extends AbstractContextLoaderInitializer {
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return new AnnotationConfigWebApplicationContext();
    }
}
