package com.zxb.thinking.in.spring.boot.samples.spring3.server;

import org.springframework.stereotype.Component;

/**
 * ftp 服务器 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:04
 */
@Component  // 根据 ImportSelector 的契约，请确保是实现为 Spring 组件
public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("Ftp服务器启动中...");
    }

    @Override
    public void stop() {
        System.out.println("Ftp服务器停止中...");
    }
}
