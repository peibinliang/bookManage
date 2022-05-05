package com.book.manage.sample.service;

import com.book.manage.core.model.RemoteResponse;

/**
 * 欢迎服务接口
 * @author ~
 * @date 2022/04/11 16:14
 */
public interface WelcomeService {

    /**
     * 获取欢迎语
     * @author ~
     * @date 2022/04/11 16:14
     */
    RemoteResponse<String> getWords();
}
