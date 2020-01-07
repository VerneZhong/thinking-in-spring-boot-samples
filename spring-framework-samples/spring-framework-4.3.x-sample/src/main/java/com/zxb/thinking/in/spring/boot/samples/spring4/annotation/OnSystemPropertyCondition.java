package com.zxb.thinking.in.spring.boot.samples.spring4.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

/**
 * 指定系统属性名称与值匹配条件 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 15:00
 */
public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取 ConditionalOnSystemProperty 所有的属性方法值
        MultiValueMap<String, Object> attributes =
                metadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        // 获取 ConditionalOnSystemProperty#name() 方法值（单值）
        String name = (String) attributes.getFirst("name");
        // 获取 ConditionalOnSystemProperty#value() 方法值（单值）
        String value = (String) attributes.getFirst("value");

        String property = System.getProperty(name);
        // 比较 系统属性值 与 ConditionalOnSystemProperty#value() 方法值 是否相等
        if (Objects.equals(value, property)) {
            System.out.printf("系统属性[名称 : %s] 找到匹配值 : %s\n", name , value);
            return true;
        }
        return false;
    }
}
