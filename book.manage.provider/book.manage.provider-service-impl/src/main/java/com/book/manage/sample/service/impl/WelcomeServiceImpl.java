package com.book.manage.sample.service.impl;

import com.book.manage.core.model.RemoteResponse;
import com.book.manage.sample.service.WelcomeService;
import org.springframework.stereotype.Service;

/**
 * 欢迎服务接口实现
 * @author ~
 * @date 2022/04/11 16:14
 */
@Service("welcomeService")
public class WelcomeServiceImpl implements WelcomeService {

    @Override
    public RemoteResponse<String> getWords() {
        return RemoteResponse.success("Welcome to Dubbo.");
    }
}
