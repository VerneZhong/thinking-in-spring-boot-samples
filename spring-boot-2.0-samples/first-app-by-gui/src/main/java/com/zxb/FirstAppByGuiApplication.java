package com.zxb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class FirstAppByGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class, args);

//		String s = "java.protocol.handler.pkgs";
//		String property = System.getProperty(s);
//		System.out.println(property);
    }

    /**
     * Webflux 示例实现
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
		return RouterFunctions.route(RequestPredicates.GET("/hello-world"),
				request -> ok().body(Mono.just("hello, world"), String.class));
    }

//    /**
//     * spring boot 启动后回调，但这种方式没要考虑到非Web应用类型的场景
//     * 在非Web应用中运行，会出现注入 WebServerApplicationContext 失败
//     *
//     * @param context
//     * @return
//     */
//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context) {
//        return args -> System.out.println("当前 WebServer 实现类：" + context.getWebServer().getClass().getName());
//    }

    /**
     * 监听 {@link org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent }
     * 事件来获取 WebServer
     * @param event
     */
    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前 WebServer 实现类：" + event.getWebServer().getClass().getName());
    }
}
