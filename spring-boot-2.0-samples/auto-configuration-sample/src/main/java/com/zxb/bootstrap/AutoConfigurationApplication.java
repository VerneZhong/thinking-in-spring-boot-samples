package com.zxb.bootstrap;

import com.zxb.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2019-12-13 17:12
 */
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
//@SpringBootApplication(scanBasePackages = "com.zxb.config")

    @EnableAutoConfiguration
public class AutoConfigurationApplication {

    public static void main(String[] args) {

//        SpringApplication.run(WebConfiguration.class, args);

        SpringApplication.run(AutoConfigurationApplication.class, args);
    }
}
