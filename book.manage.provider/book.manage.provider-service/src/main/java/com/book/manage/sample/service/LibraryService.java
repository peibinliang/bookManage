package com.book.manage.sample.service;

import com.book.manage.core.dto.req.LibraryReqDto;
import com.book.manage.core.dto.resp.LibraryRespDto;
import com.book.manage.core.exception.BusinessException;

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

    /**
     * 新增图书库
     * @param libraryReqDto
     * @return
     */
    boolean saveLibrary(LibraryReqDto libraryReqDto) throws BusinessException;

    /**
     * 根据图书库Id获取图书库
     * @param libraryId
     * @return
     */
    LibraryRespDto getLibraryByLibraryId(Integer libraryId);

    /**
     * 编辑图书库
     * @param libraryReqDto
     * @return
     */
    boolean modifyLibrary(LibraryReqDto libraryReqDto) throws BusinessException;
}
