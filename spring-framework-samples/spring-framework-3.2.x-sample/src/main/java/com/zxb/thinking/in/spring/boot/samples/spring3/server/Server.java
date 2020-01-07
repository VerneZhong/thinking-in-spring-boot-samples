package com.zxb.thinking.in.spring.boot.samples.spring3.server;

/**
 * 服务器 interface
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:03
 */
public interface Server {

    /**
     * 启动服务器
     */
    void start();

    /**
     * 关闭服务器
     */
    void stop();

    /**
     * 服务器类型
     */
    enum Type {
        HTTP, FTP
    }
}
