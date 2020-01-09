package com.zxb.thinking.in.spring.boot.samples.spring5.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring5.annotation.TransactionalService;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link TransactionalService} 注解反射引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-08 17:24
 */
@TransactionalService(name = "test")
public class TransactionalServiceAnnotationReflectionBootstrap {

    public static void main(String[] args) {
        // Class 实现了 AnnotatedElement接口
        AnnotatedElement annotatedElement = TransactionalServiceAnnotationReflectionBootstrap.class;
        // 从 AnnotatedElement 获取 TransactionalService
        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
        // 显示地调用属性方法 TransactionalService#name() 获取属性
//        String name = transactionalService.name();
//        System.out.println("TransactionalService.name() = " + name);

        // 输出注解属性
        printAnnotationAttribute(transactionalService);

        // 获取 transactionalService 的所有元注解
        Set<Annotation> allMetaAnnotations = getAllMetaAnnotations(transactionalService);

        // 输出结果
        allMetaAnnotations.forEach(TransactionalServiceAnnotationReflectionBootstrap::printAnnotationAttribute);
    }

    private static Set<Annotation> getAllMetaAnnotations(Annotation annotation) {
        Annotation[] annotations = annotation.annotationType().getAnnotations();

        if (ObjectUtils.isEmpty(annotations)) {
            return Collections.emptySet();
        }

        // 获取所有非 Java 标注的元注解集合
        Set<Annotation> metaAnnotationSet = Stream.of(annotations)
                // 排除 Java 标准注解，如@Target/@Documented等，它们因互相依赖，将导致递归不断
                // 通过 java.lang.annotation 包名排除
                .filter(metaAnnotation -> !Target.class.getPackage()
                        .equals(metaAnnotation.annotationType().getPackage()))
                .collect(Collectors.toSet());

        // 递归查找元注解的元注解集合
        Set<Annotation> metaMetaAnnotationSet = metaAnnotationSet.stream()
                .map(TransactionalServiceAnnotationReflectionBootstrap::getAllMetaAnnotations)
                .collect(HashSet::new, Set::addAll, Set::addAll);

        // 添加递归结果
        metaAnnotationSet.addAll(metaMetaAnnotationSet);

        return metaAnnotationSet;
    }

    private static void printAnnotationAttribute(Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        // 完全Java反射实现（ReflectionUtils 为 Spring反射工具）
        ReflectionUtils.doWithMethods(annotationType,
                method -> System.out.printf("@%s.%s() = %s\n",
                        annotationType.getSimpleName(), method.getName(),
                        // 执行 Method 反射调用
                        ReflectionUtils.invokeMethod(method, annotation)),
                // 选择无参数方法
//                method -> method.getParameterCount() == 0);
                // 选择非 Annotation 方法
                method -> !method.getDeclaringClass().equals(Annotation.class));
    }
}
