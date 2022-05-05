package com.book.manage.sample;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sample服务启动类
 * @author ~
 * @date 2022/04/11 16:14
 */
@SpringBootApplication
@MapperScan("com.book.manage.core.mapper")
@Slf4j
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class);
        log.info("示例服务工程启动完成");
    }
}
