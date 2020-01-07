package com.zxb.thinking.in.spring.boot.samples.spring3.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * lambda 实现计算服务 class
 *
 * @author Mr.zxb
 * @date 2020-01-07 09:39
 */
@Service
@Profile("Java8")
public class LambdaCalculatingService implements CalculatingService {
    @Override
    public Integer sum(Integer... args) {
        Integer sum = Stream.of(args).reduce(0, Integer::sum);
        System.out.printf("[Java 8 Lambda实现] %s 累加结果 : %d\n", Arrays.asList(args), sum);
        return sum;
    }
}
