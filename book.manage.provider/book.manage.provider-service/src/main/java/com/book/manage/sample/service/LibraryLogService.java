package com.book.manage.sample.service;

import com.book.manage.core.entity.LibraryLog;

/**
 * <p>
 *  图书库操作记录服务
 * </p>
 *
 * @author liangpeibin
 * @since 2022/5/7
 */
public interface LibraryLogService {
    /**
     * 新增书籍操作记录
     * @param libraryLog
     * @return
     */
    boolean saveLibraryLog(LibraryLog libraryLog);
}
