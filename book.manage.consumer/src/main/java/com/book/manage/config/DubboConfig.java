package com.book.manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * API消费者文件配置
 * @author ~
 * @date 2022/04/11 16:14
 */
@Configuration
@ImportResource("classpath:book.manage.consumer-consumer.xml")
public class DubboConfig {
}
