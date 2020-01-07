package com.zxb.thinking.in.spring.boot.samples.spring3.service;

/**
 * 计算服务 interface
 *
 * @author Mr.zxb
 * @date 2020-01-07 09:36
 */
public interface CalculatingService {

    /**
     * 多个值累加
     * @param args
     * @return
     */
    Integer sum(Integer... args);
}
