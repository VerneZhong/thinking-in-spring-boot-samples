package com.zxb.thinking.in.spring.boot.samples.spring3.bootstrap;

import com.zxb.thinking.in.spring.boot.samples.spring3.annotation.EnableServer;
import com.zxb.thinking.in.spring.boot.samples.spring3.server.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * {@link EnableServer} 引导类 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:14
 */
@EnableServer(type = Server.Type.HTTP)
@Configuration
public class EnableServerBootstrap {

    public static void main(String[] args) {
        // 构建 Annotation 配置驱动 Spring 上下文
        // 注册 当前引导类（被 @Configuration 标注） 到 Spring 上下文
        // 并启动上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EnableServerBootstrap.class);

        // 获取 Server Bean 对象，实际为 HttpServer
        Server server = context.getBean(Server.class);

        server.start();
        server.stop();
        // 关闭上下文
        context.close();
    }
}
