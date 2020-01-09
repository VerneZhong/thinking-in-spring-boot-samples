package com.zxb.thinking.in.spring.boot.samples.spring5.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring5.bean.TransactionalServiceBean;
import org.springframework.context.annotation.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;

import java.util.Map;

/**
 * {@link TransactionalServiceBean} 引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-09 15:05
 */
@Configuration
// 扫描Bean
@ComponentScan(basePackageClasses = TransactionalServiceBean.class)
// 激活事务管理器
@EnableTransactionManagement
public class TransactionalServiceBeanBootstrap {

    public static void main(String[] args) {
        // 注册当前引导类作为 Configuration Class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TransactionalServiceBeanBootstrap.class);

        // 获取所有 TransactionalServiceBean 类型 Bean，其中 Key 为 Bean名称
        Map<String, TransactionalServiceBean> beansOfType = context.getBeansOfType(TransactionalServiceBean.class);

        beansOfType.forEach((beanName, bean) -> {
            System.out.printf("Bean 名称：%s, 对象：%s\n", beanName, bean);
            bean.save();
        });

        // 关闭上下文
        context.close();
    }

    @Bean("txManager")
    public PlatformTransactionManager txManager() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager：事务提交...");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {
                System.out.println("txManager：事务回滚...");
            }
        };
    }

    @Bean("txManager2")
    public PlatformTransactionManager txManager2() {
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager2：事务提交...");
            }

            @Override
            public void rollback(TransactionStatus status) throws TransactionException {
                System.out.println("txManager2：事务回滚...");
            }
        };
    }
}
