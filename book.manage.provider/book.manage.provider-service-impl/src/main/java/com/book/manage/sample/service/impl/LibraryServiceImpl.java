package com.book.manage.sample.service.impl;

import com.book.manage.core.Mapper.LibraryMapper;
import com.book.manage.core.dto.resp.LibraryRespDto;
import com.book.manage.sample.service.LibraryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liangpeibin
 * @ClassName LibraryServiceImpl
 * @Description
 * @since 2022/5/4 16:45
 */
@Service("libraryService")
@DubboService
public class LibraryServiceImpl implements LibraryService {
    @Resource
    private LibraryMapper libraryMapper;

    /**
     * 用户的图书库列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<LibraryRespDto> listLibraryByUserId(Integer userId) {
        return libraryMapper.listLibraryByUser(userId);
    }
}
