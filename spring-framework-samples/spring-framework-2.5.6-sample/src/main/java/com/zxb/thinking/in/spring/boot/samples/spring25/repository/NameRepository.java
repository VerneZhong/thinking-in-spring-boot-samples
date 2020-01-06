package com.zxb.thinking.in.spring.boot.samples.spring25.repository;

import com.zxb.thinking.in.spring.boot.samples.spring25.annotation.StringRepository;

import java.util.Arrays;
import java.util.List;

/**
 * 名字仓储，Bean 名称为 "chineseNameRepository" class
 *
 * @author Mr.zxb
 * @date 2020-01-06 14:28
 */
@StringRepository("chineseNameRepository")
public class NameRepository {

    public List<String> findAll() {
        return Arrays.asList("张三", "李四", "钟学斌");
    }
}
