package com.zxb.thinking.in.spring.boot.samples.spring5.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * {@link Transactional @Transactional} 和 {@link Service @Service} 组合注解 annotation
 *
 * @author Mr.zxb
 * @date 2020-01-08 16:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional
@Service("transactionalService")
public @interface TransactionalService {

    /**
     * 服务Bean名称
     *
     * @return
     */
    @AliasFor("value")
    String name() default "txManager";

    /**
     * 覆盖 {@link Transactional#transactionManager()} 默认值
     *
     * @return {@link PlatformTransactionManager} Bean 名称，默认关联 "txManager2" Bean
     */
//    String transactionManager() default "txManager";

    /**
     * 覆盖 {@link Transactional#value()} 默认值
     * @return {@link PlatformTransactionManager} Bean 名称，默认关联 "txManager" Bean
     */
    @AliasFor("name")
    String value() default "txManager";

    /**
     * 建立 {@link Transactional#transactionManager()} 别名
     * @return {@link PlatformTransactionManager} Bean 名称，默认关联"txManager" Bean
     */
    @AliasFor(attribute = "transactionManager", annotation = Transactional.class)
    String manager() default "txManager2";
}
