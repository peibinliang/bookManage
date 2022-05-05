package com.book.manage.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Dubbo配置导入
 * @author ~
 * @date 2022/04/11 16:14
 */
@Configuration
@ImportResource("classpath:book.manage.provider-provider.xml")
public class DubboConfig {
}
