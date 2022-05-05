package com.book.manage.core.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.manage.core.dto.resp.LibraryRespDto;
import com.book.manage.core.entity.Library;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  图书库表 Mapper接口
 * </p>
 *
 * @author liangpeibin
 * @since 2022/5/4
 */
public interface LibraryMapper extends BaseMapper<Library> {
    /**
     * 用户关联图书库
     * @param userId
     * @return
     */
    List<LibraryRespDto> listLibraryByUser(@Param("userId") Integer userId);
}
