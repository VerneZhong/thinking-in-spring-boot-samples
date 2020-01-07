package com.zxb.thinking.in.spring.boot.samples.spring3.selector;

import com.zxb.thinking.in.spring.boot.samples.spring3.annotation.EnableServer;
import com.zxb.thinking.in.spring.boot.samples.spring3.server.FtpServer;
import com.zxb.thinking.in.spring.boot.samples.spring3.server.HttpServer;
import com.zxb.thinking.in.spring.boot.samples.spring3.server.Server;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 服务器 {@link ImportSelector} 实现 class
 *
 * @author Mr.zxb
 * @date 2020-01-06 16:08
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 读取 EnableServer 中的所有的属性方法，本例中仅有 type() 属性方法
        // 其中 key 为 属性方法的名称，value 为属性方法返回对象
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        // 获取名为"type" 的属相方法，并且强制转化成 Server.Type 类型
        Server.Type type = (Server.Type) attributes.get("type");
        // 导入的类名称数组
        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP:
                // 当设置 HTTP 服务器类型时，返回 HttpServer 组件
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                //  当设置 FTP  服务器类型时，返回 FtpServer  组件
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
            default:
                break;
        }
        return importClassNames;
    }
}
