package com.book.manage.sample.service;

import com.book.manage.core.dto.resp.LibraryRespDto;

import java.util.List;

/**
 * <p>
 *  图书库服务类
 * </p>
 *
 * @author liangpeibin
 * @since 2022/5/4
 */
public interface LibraryService {
    /**
     * 用户的图书库列表
     * @param userId
     * @return
     */
    List<LibraryRespDto> listLibraryByUserId(Integer userId);
}
