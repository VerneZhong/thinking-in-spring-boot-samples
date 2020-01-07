package com.zxb.thinking.in.spring.boot.samples.spring3.selector;

import com.zxb.thinking.in.spring.boot.samples.spring3.server.Server;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * {@link Server} {@link ImportBeanDefinitionRegistrar} 的实现 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 09:24
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 复用 {@link ServerImportSelector} 实现，避免重复劳动
        ImportSelector importSelector = new ServerImportSelector();
        // 筛选 Class 名称集合
        String[] selectImports = importSelector.selectImports(importingClassMetadata);
        // 创建Bean定义
        Stream.of(selectImports)
                // 转化为 BeanDefinitionBuilder 对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为 BeanDefinition 对象
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(abstractBeanDefinition -> {
                    // 注册 BeanDefinition 到 BeanDefinitionRegistry
                    BeanDefinitionReaderUtils.registerWithGeneratedName(abstractBeanDefinition, registry);
                });
    }
}
