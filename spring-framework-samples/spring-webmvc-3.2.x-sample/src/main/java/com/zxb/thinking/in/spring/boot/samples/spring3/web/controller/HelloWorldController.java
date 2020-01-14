package com.zxb.thinking.in.spring.boot.samples.spring3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello World {@link Controller}
 *
 * @author Mr.zxb
 * @date 2020-01-14 17:04
 */
@Controller
public class HelloWorldController {

    @RequestMapping
    @ResponseBody
    public String helloWorld() {
        return "Hello,World!!!";
    }
}
