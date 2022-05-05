package com.book.manage.core.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.manage.core.dto.resp.UserRespDto;
import com.book.manage.core.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  用户表 Mapper接口
 * </p>
 *
 * @author liangpeibin
 * @since 2022/5/2
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    UserRespDto getUserByUserName(@Param("userName") String userName);

    /**
     * 用户列表
     * @param start
     * @return
     */
    List<UserRespDto> listUser(@Param("start") Integer start);

    /**
     * 获取用户列表条数
     * @return
     */
    Integer getUserListSize();
}
