package cn.xquu.project.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    private static final Logger log = LoggerFactory.getLogger(EurekaApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EurekaApplication.class, args);
        log.info("{}项目启动成功！地址:  http://localhost:{}/{}}",
                context.getEnvironment().getProperty("spring.application.name"),
                context.getEnvironment().getProperty("server.port"),
                context.getEnvironment().getProperty("spring.application.name"));
    }
}
