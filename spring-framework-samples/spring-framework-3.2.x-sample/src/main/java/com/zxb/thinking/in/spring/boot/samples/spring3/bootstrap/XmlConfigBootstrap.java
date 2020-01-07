package com.zxb.thinking.in.spring.boot.samples.spring3.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring3.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XML 配置驱动引导程序 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:00
 */
public class XmlConfigBootstrap {

    public static void main(String[] args) {
        // 构建 XML 配置驱动 Spring 上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();

        // 设置 xml 配置路径
        context.setConfigLocation("classpath:/META-INF/spring/context.xml");

        // 启动上下文
        context.refresh();

        // 获取名称为 "user" Bean 对象
        User user = context.getBean("user", User.class);
        // 输出用户名称："钟学斌"
        System.out.printf("user.getName() = %s \n",user.getName());
        // 关闭 Spring 上下文
        context.close();
    }
}
