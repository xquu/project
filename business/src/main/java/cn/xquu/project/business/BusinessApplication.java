package cn.xquu.project.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("cn.xquu")
public class BusinessApplication {
    private static final Logger log = LoggerFactory.getLogger(BusinessApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BusinessApplication.class, args);
        log.info("项目启动成功！business地址:\t http://localhost:{}/business", context.getEnvironment().getProperty("server.port"));
    }
}