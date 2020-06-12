package cn.xquu.project.business.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("cn.xquu.project")
@MapperScan("cn.xquu.project.server.mapper")
public class BusinessApplication {
    private static final Logger log = LoggerFactory.getLogger(BusinessApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BusinessApplication.class, args);
        log.info("{}项目启动成功！地址:  http://localhost:{}/{}",
                context.getEnvironment().getProperty("spring.application.name"),
                context.getEnvironment().getProperty("server.port"),
                context.getEnvironment().getProperty("spring.application.name"));
    }
}
