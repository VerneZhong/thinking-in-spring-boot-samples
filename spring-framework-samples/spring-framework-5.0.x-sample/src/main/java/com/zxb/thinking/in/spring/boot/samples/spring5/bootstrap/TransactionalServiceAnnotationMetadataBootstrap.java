package com.zxb.thinking.in.spring.boot.samples.spring5.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring5.annotation.TransactionalService;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * {@link TransactionalService @TransactionalService} 注解元信息引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-08 16:58
 */
@TransactionalService
public class TransactionalServiceAnnotationMetadataBootstrap {

    public static void main(String[] args) throws IOException {
        // @TransactionalService 标注在当前类 TransactionalServiceAnnotationMetadataBootstrap
        String className = TransactionalServiceAnnotationMetadataBootstrap.class.getName();

        // 构建 MetadataReaderFactory 对象
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();

        // 读取 @TransactionalService MetadataReader 信息
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
        // 读取 @TransactionService AnnotationMetadata 信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();

        annotationTypes.forEach(annotationType -> {
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            metaAnnotationTypes.forEach(metaAnnotationType -> {
                // 输出
                System.out.printf("注解 @%s 元标注 @%s\n", annotationType, metaAnnotationType);
            });
        });
    }
}
