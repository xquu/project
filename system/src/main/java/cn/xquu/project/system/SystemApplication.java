package cn.xquu.project.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class SystemApplication {
    private static final Logger log = LoggerFactory.getLogger(SystemApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SystemApplication.class, args);
        log.info("项目启动成功！system地址:\t http://localhost:{}",context.getEnvironment().getProperty("server.port"));

    }
}
