package com.zxb.thinking.in.spring.boot.samples.spring3.annotation;

import com.zxb.thinking.in.spring.boot.samples.spring3.selector.ServerImportBeanDefinitionRegistrar;
import com.zxb.thinking.in.spring.boot.samples.spring3.selector.ServerImportSelector;
import com.zxb.thinking.in.spring.boot.samples.spring3.server.Server;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活服务器 annotation
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class)
@Import({ServerImportBeanDefinitionRegistrar.class}) // 替换 ServerImportSelector
public @interface EnableServer {

    /**
     * 设置服务器类型
     * @return non-null
     */
    Server.Type type();
}
