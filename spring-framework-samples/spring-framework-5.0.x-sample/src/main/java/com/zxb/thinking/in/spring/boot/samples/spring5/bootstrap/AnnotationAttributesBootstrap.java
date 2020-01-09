package com.zxb.thinking.in.spring.boot.samples.spring5.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring5.annotation.TransactionalService;
import com.zxb.thinking.in.spring.boot.samples.spring5.bean.TransactionalServiceBean;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.AnnotatedElement;

/**
 * {@link AnnotationAttributes} 引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-09 14:13
 */
public class AnnotationAttributesBootstrap {

    public static void main(String[] args) {

//        AnnotatedElement annotatedElement = TransactionalService.class;

        AnnotatedElement annotatedElement = TransactionalServiceBean.class;

        // 获取 @Service 注解属性独享
        AnnotationAttributes serviceAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement
                , Service.class);

        // 获取 @TransactionalService 注解属性独享
        AnnotationAttributes transactionalAttributes =
                AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement
                , Transactional.class);

        // 输出
        print(serviceAttributes);

        print(transactionalAttributes);
    }

    private static void print(AnnotationAttributes annotationAttributes) {
        System.out.printf("注解 @%s 属性集合: \n", annotationAttributes.annotationType().getName());

        annotationAttributes.forEach((name, value) -> System.out.printf("\t 属性 %s : %s \n", name, value));
    }
}
