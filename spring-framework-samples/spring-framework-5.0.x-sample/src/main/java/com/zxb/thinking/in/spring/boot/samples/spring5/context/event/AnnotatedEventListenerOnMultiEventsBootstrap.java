package com.zxb.thinking.in.spring.boot.samples.spring5.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;

/**
 * {@link EventListener @EventListener} 监听多 Spring 事件的引导类，检验：
 * <ul>
 * <li>是否支持单一 {@link ApplicationContextEvent}参数 --> true</li>
 * <li>是否支持多参数  --> false</li>
 * </ul>
 * 结论：
 * 事件监听器最多只支持一个参数 {@link ApplicationEvent} 及其子类
 * @author Mr.zxb
 * @date 2020-01-09 16:44
 */
public class AnnotatedEventListenerOnMultiEventsBootstrap {

    public static void main(String[] args) {
        // 创建 注解驱动 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 @EventListener 类 MyMultiEventsListener
        context.register(MyMultiEventsListener.class);
        // 初始化上下文
        context.refresh();
        // 关闭上下文
        context.close();
    }

    /**
     * 具体 {@link EventListener} 类，提供不同监听多 Spring 事件方法
     */
    public static class MyMultiEventsListener {

        /**
         * 无参数监听 {@link ContextRefreshedEvent}、{@link ContextClosedEvent}、
         * {@link ContextStartedEvent} 和 {@link ContextStoppedEvent} 事件
         */
        @EventListener({ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void onEvent() {
            System.out.println("onEvent");
        }

        /**
         * 不支持多参数
         * {@link ContextRefreshedEvent} 和 {@link ContextClosedEvent} 参数监听
         * @param refreshedEvent    {@link ContextRefreshedEvent}
         * @param closedEvent       {@link ContextClosedEvent}
         */
        @EventListener({ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void onEvents(ContextRefreshedEvent refreshedEvent, ContextClosedEvent closedEvent) {
            System.out.println("onEvents : " + refreshedEvent.getClass().getSimpleName()
                    + " , " + closedEvent.getClass().getSimpleName());
        }

        /**
         * 单一 {@link ApplicationContextEvent} 参数监听 {@link ContextRefreshedEvent} 和 {@link ContextClosedEvent} 事件
         *
         * @param event {@link ApplicationEvent}
         */
        @EventListener({ContextRefreshedEvent.class, ContextClosedEvent.class})
        public void onApplicationContextEvent(ApplicationEvent event) {
            System.out.println("onApplicationContextEvent : " + event.getClass().getSimpleName());
        }
    }
}
