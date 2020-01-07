package com.zxb.thinking.in.spring.boot.samples.spring3.server;

import org.springframework.stereotype.Component;

/**
 * Http 服务器 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:06
 */
@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("Http服务器启动中...");
    }

    @Override
    public void stop() {
        System.out.println("Http服务器停止中...");
    }
}
