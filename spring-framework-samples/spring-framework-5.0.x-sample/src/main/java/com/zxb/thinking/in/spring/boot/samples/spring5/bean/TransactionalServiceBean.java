package com.zxb.thinking.in.spring.boot.samples.spring5.bean;

import com.zxb.thinking.in.spring.boot.samples.spring5.annotation.TransactionalService;

/**
 * {@link TransactionalService} Bean class
 *
 * @author Mr.zxb
 * @date 2020-01-09 15:04
 */
@TransactionalService(name = "transactionalService")
public class TransactionalServiceBean {

    public void save() {
        System.out.println("保存操作...");
    }
}
