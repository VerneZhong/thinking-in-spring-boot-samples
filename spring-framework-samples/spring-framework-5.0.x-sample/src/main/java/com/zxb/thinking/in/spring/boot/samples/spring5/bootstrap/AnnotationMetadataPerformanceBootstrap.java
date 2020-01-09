package com.zxb.thinking.in.spring.boot.samples.spring5.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring5.annotation.TransactionalService;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * {@link AnnotationMetadata } 实现性能比较引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-09 11:07
 */
public class AnnotationMetadataPerformanceBootstrap {

    public static void main(String[] args) throws IOException {

        // 反射实现
        AnnotationMetadata standardAnnotationMetadata = new StandardAnnotationMetadata(TransactionalService.class);

        SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();

        MetadataReader metadataReader = factory.getMetadataReader(TransactionalService.class.getName());

        // ASM 实现
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 10w 次
        int times = 10 * 10000;
        testAnnotationMetadataPerformance(standardAnnotationMetadata, times);
        testAnnotationMetadataPerformance(annotationMetadata, times);

        // 100w 次
        times = 100 * 10000;
        testAnnotationMetadataPerformance(standardAnnotationMetadata, times);
        testAnnotationMetadataPerformance(annotationMetadata, times);

        // 1000w 次
        times = 1000 * 10000;
        testAnnotationMetadataPerformance(standardAnnotationMetadata, times);
        testAnnotationMetadataPerformance(annotationMetadata, times);

        // 1亿 次
        times = 10000 * 10000;
        testAnnotationMetadataPerformance(standardAnnotationMetadata, times);
        testAnnotationMetadataPerformance(annotationMetadata, times);

    }

    private static void testAnnotationMetadataPerformance(AnnotationMetadata annotationMetadata, int times) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            annotationMetadata.getAnnotationTypes();
        }
        long costTime = System.currentTimeMillis() - startTime;
        System.out.printf("%d 次 %s.getAnnotationTypes() 方法执行消耗 %s ms\n", times, annotationMetadata.getClass().getSimpleName(), costTime);
    }
}
