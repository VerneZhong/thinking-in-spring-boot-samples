package com.zxb.thinking.in.spring.boot.samples.spring5.context.event;

import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 监听自定义事件引导类，通过{@link GenericApplicationContext#registerBean(Class, BeanDefinitionCustomizer...)}
 * 方法注册 @{@link ApplicationListener} Bean
 *
 * @author Mr.zxb
 * @date 2020-01-09 17:15
 * @see GenericApplicationContext
 * @see ApplicationEvent
 * @see ApplicationListener
 */
public class ApplicationListenerBeanOnCustomEventBootstrap {

    public static void main(String[] args) {
        // 创建 Spring 应用上下文 GenericApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();

        // 注册 ApplicationListener<MyApplicationEvent> 实现 MyApplicationListener
        context.registerBean(MyApplicationListener.class);   // registerBean 方法从 Spring 5 引入

        // 初始化上下文
        context.refresh();

        // 发布自定义事件 MyApplicationEvent
        context.publishEvent(new MyApplicationEvent("hello event."));

        // 关闭上下文
        context.close();

        // 再次发送事件
        context.publishEvent(new MyApplicationEvent("Hello World Again"));
    }

    /**
     * 自定义 {@link ApplicationEvent}
     */
    public static class MyApplicationEvent extends ApplicationEvent {

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

    /**
     * 自定义 {@link ApplicationListener}
     */
    public static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.println(event.getClass().getSimpleName() + ": " + event.getSource());
        }
    }


}
