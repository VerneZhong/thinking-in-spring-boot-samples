package com.zxb.thinking.in.spring.boot.samples.spring2.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 可配置的 {@link org.springframework.context.ApplicationContext} 引导类
 *
 * @author Mr.zxb
 * @date 2020-03-06 16:27
 */
public class ConfigurableApplicationContextBootstrap {

    static {
        // 通过系统属性 "env"，实现 "name" bean 的切换
        // envValue 可能来自 "-D" 命令行启动参数，-Denv=dev 修改环境配置
        // 当 "env" 参数不存在时，使用 "prod" 作为默认值
        String envValue = System.getProperty("env", "prod");
        System.setProperty("env", envValue);
    }

    public static void main(String[] args) {

        // 创建 XML 应用上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/configurable-context" +
                ".xml");

        // name bean 对象
        Object name = context.getBean("name");

        // 输出 bean 内容
        System.out.println(name);

        // 关闭上下文
        context.close();
    }
}
