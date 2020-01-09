package com.zxb.thinking.in.spring.boot.samples.spring5.context.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * {@link EventListener @EventListener 注解驱动事件监听器} 引导类，检验：
 * <ul>
 * <li>{@link EventListener @EventListener} public 方法有返回值是否工作正常</li>
 * <li>在抽象类中声明的{@link EventListener @EventListener} public 方法，是否能在子类 Bean 中正常工作</li>
 * </ul>
 *
 * @author Mr.zxb
 * @date 2020-01-09 16:31
 * @see EventListener
 */
public class AnnotatedEventListenerBootstrap {

    public static void main(String[] args) {

        // 创建注解驱动上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // 注册 @EventListener 类 MyEventListener
        context.register(MyEventListener.class);

        // 初始化上下文
        context.refresh();

        // 关闭上下文
        context.close();
    }

    /**
     * {@link EventListener} 抽象类
     */
    public static abstract class AbstractEventListener {
        /**
         * 监听上下文刷新事件
         * @param event
         */
        @EventListener(ContextRefreshedEvent.class)
        public void onContextRefreshedEvent(ContextRefreshedEvent event) {
            System.out.println("AbstractEventListener : " + event.getClass().getSimpleName());
        }
    }

    /**
     * 具体 {@link EventListener}类，作为 Spring Bean，继承 {@link AbstractEventListener}
     */
    public static class MyEventListener extends AbstractEventListener {
        /**
         * 监听上下文关闭事件
         * @param event
         * @return
         */
        @EventListener(ContextClosedEvent.class)
        public boolean onContextClosedEvent(ContextClosedEvent event) {
            System.out.println("MyEventListener : " + event.getClass().getSimpleName());
            return true;
        }
    }
}
