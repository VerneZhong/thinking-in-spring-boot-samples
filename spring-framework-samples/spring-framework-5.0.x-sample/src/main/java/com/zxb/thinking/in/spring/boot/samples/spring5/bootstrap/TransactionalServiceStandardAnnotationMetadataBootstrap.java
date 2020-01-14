package com.zxb.thinking.in.spring.boot.samples.spring5.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring5.annotation.TransactionalService;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@link TransactionalService @TransactionalService} 基于Java反射API的 {@link StandardAnnotationMetadata} 实现 引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-09 10:55
 */
@TransactionalService
public class TransactionalServiceStandardAnnotationMetadataBootstrap {

    public static void main(String[] args) {

        // 读取 @TransactionalService AnnotationMetadata 信息
        AnnotationMetadata annotationMetadata =
                new StandardAnnotationMetadata(TransactionalServiceStandardAnnotationMetadataBootstrap.class);

        // 获取所有的元注解类型（全类名）集合
        Set<String> metaAnnotationTypes = annotationMetadata.getAnnotationTypes()
                .stream()
                // 读取单注解的元注解类型集合
                .map(annotationMetadata::getMetaAnnotationTypes)
                // 合并元注解类型（全类名）集合
                .collect(HashSet::new, Set::addAll, Set::addAll);

        metaAnnotationTypes.forEach(metaAnnotation -> {
            Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(metaAnnotation);

            if (!CollectionUtils.isEmpty(attributes)) {
                attributes.forEach((name, value) -> System.out.printf("注解 @%s 属性 %s = %s\n",
                        ClassUtils.getShortName(metaAnnotation), name, value));
            }
        });

    }
}
