package com.zxb.thinking.in.spring.boot.samples.spring3.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 迭代计算实现 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 09:37
 */
@Service
@Profile("Java7")
public class IterationCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... args) {
        int sum = 0;
        for (Integer arg : args) {
           sum += arg;
        }
        System.out.printf("[Java 7 迭代实现] %s 累加结果 : %d\n", Arrays.asList(args), sum);
        return sum;
    }
}
