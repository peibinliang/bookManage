package com.book.manage.sample.service.impl;

import com.book.manage.core.Mapper.LibraryLogMapper;
import com.book.manage.core.entity.LibraryLog;
import com.book.manage.sample.service.LibraryLogService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liangpeibin
 * @ClassName LibraryLogServiceImpl
 * @Description
 * @since 2022/5/7 16:52
 */
@Service("libraryLogService")
@DubboService
public class LibraryLogServiceImpl implements LibraryLogService {
    @Resource
    private LibraryLogMapper libraryLogMapper;

    /**
     * 新增书籍操作记录
     *
     * @param libraryLog
     * @return
     */
    @Override
    public boolean saveLibraryLog(LibraryLog libraryLog) {
        return libraryLogMapper.insert(libraryLog)>0;
    }
}
