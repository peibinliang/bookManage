package com.book.manage.sample.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.book.manage.core.Mapper.LibraryMapper;
import com.book.manage.core.dto.req.LibraryReqDto;
import com.book.manage.core.dto.resp.LibraryRespDto;
import com.book.manage.core.entity.Library;
import com.book.manage.core.enums.UserStateCode;
import com.book.manage.core.exception.BusinessException;
import com.book.manage.core.utils.UserUtils;
import com.book.manage.sample.service.LibraryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    /**
     * 新增图书库
     *
     * @param libraryReqDto
     * @return
     */
    @Override
    public boolean saveLibrary(LibraryReqDto libraryReqDto) throws BusinessException {
        if (Objects.nonNull(libraryMapper.getLibraryByLibraryName(libraryReqDto.getLibraryName()))){
            throw new BusinessException(UserStateCode.BU10009);
        }
        libraryReqDto.setLibraryNo(UserUtils.generateLibraryNo());
        return libraryMapper.insert(BeanUtil.toBean(libraryReqDto, Library.class))>0;
    }

    /**
     * 根据图书库Id获取图书库
     *
     * @param libraryId
     * @return
     */
    @Override
    public LibraryRespDto getLibraryByLibraryId(Integer libraryId) {
        return BeanUtil.toBean(libraryMapper.selectById(libraryId),LibraryRespDto.class);
    }

    /**
     * 编辑图书库
     *
     * @param libraryReqDto
     * @return
     */
    @Override
    public boolean modifyLibrary(LibraryReqDto libraryReqDto) throws BusinessException {
        if (Objects.nonNull(libraryMapper.getLibraryByLibraryName(libraryReqDto.getLibraryName()))){
            throw new BusinessException(UserStateCode.BU10009);
        }
        return libraryMapper.updateById(BeanUtil.toBean(libraryReqDto,Library.class))>0;
    }
}
