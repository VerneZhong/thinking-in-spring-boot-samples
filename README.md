# spring-boot-programming-thinking
SpringBoot编程思想一书案例项目

 ### 第一章 初览Spring Boot
  准备环境：
  * JDK8
  * Maven
 
 ### 第二章 理解独立的Spring应用
   #### 创建Spring Boot应用
   命令行创建SpringBoot 应用
   1. 编辑好pom文件
```
    <?xml version="1.0" encoding="UTF-8”?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd”>     
        <modelVersion>4.0.0</modelVersion>                                                                          
        <groupId>com.example</groupId> 
        <artifactId>myproject</artifactId>
        <version>0.0.1-SNAPSHOT</version> 
    
         <parent>     
            <groupId>org.springframework.boot</groupId> 
            <artifactId>spring-boot-starter-parent</artifactId>       
            <version>2.2.1.RELEASE</version>                             
         </parent>
        
    </project>
```
   2. 使用Maven Archetype插件
   3. 执行命令生成代码
```
   $ mvn archetype:generate -DgroupId=thinking-in-spring-boot -DartifactId=first-spring-boot-application -Dversion=1.0.0-SHAPSHOT -DinteractiveMode=false -Dpackage=thinking.in.spring.boot
   [INFO] ----------------------------------------------------------------------------
   [INFO] Parameter: basedir, Value: /Users/zhongxuebin/SpringProject/thinking-in-spring-boot-samples
   [INFO] Parameter: package, Value: thinking.in.spring.boot
   [INFO] Parameter: groupId, Value: thinking-in-spring-boot
   [INFO] Parameter: artifactId, Value: first-spring-boot-application
   [INFO] Parameter: packageName, Value: thinking.in.spring.boot
   [INFO] Parameter: version, Value: 1.0.0-SNAPSHOT
   [INFO] project created from Old (1.x) Archetype in dir: /Users/zhongxuebin/SpringProject/thinking-in-spring-boot-samples/first-spring-boot-application
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  1.967 s
   [INFO] Finished at: 2019-12-05T11:56:58+08:00
   [INFO] ------------------------------------------------------------------------
    
   $ mvn spring-boot:run
```   
 #### 解读构建命令：
   * mvn Maven命令--mvn
   * 插件简称--archetype
   * 插件目标--archetype:generate
   * 插件参数--通过-D命令行参数设置Java的系统属性
       * -DgroupId
       * -DartifactId
       * -Dversion
       * -Dpackage
   * 交互模式参数—interactiveMode，当参数为false时，表示非交互式构建（静默方式）
   注意：需要额外添加SpringBoot依赖
   
### 第三章 理解固化的Maven依赖
   如果使用了maven-war-plugin插件，需要配置repackage元素，否则不会添加Spring Boot引导依赖，进而无法引导当前应用
```
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <version>2.2.1.RELEASE</version>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>

        <!-- 保持与 spring-boot-dependencies 版本一致 -->
        <plugin>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.3</version>
        </plugin>
    </plugins>
</build>....
```
   

   