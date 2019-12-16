package com.zxb.autoconfigure;

import com.zxb.config.WebConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动配置类
 *
 * @author Mr.zxb
 * @date 2019-12-15 21:55
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}
