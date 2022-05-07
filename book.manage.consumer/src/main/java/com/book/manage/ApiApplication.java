package com.book.manage;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * API应用启动类
 * @author ~
 * @date 2022/04/11 16:14
 */
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.book.manage","com.book.manage.interceptor"})
@DubboComponentScan("com.bncloud")
@Slf4j
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
        log.info("API工程启动完成");
    }
}
