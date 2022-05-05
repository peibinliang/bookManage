package com.book.manage.sample.service;

import com.book.manage.core.dto.req.UserReqDto;
import com.book.manage.core.dto.resp.UserRespDto;
import com.book.manage.core.exception.BusinessException;

import java.util.List;

/**
 * <p>
 *  用户服务类
 * </p>
 *
 * @author liangpeibin
 * @since 2022/4/12
 */
public interface UserService {
    /**
     * 新增用户
     * @param userReqDto
     * @return
     */
    boolean saveUser(UserReqDto userReqDto) throws BusinessException;

    /**
     * 用户登录
     * @param user
     * @return
     */
    UserRespDto login(UserReqDto user) throws BusinessException;

    /**
     * 忘记密码
     * @param userReqDto
     * @return
     */
    boolean forgerPassword(UserReqDto userReqDto) throws BusinessException;

    /**
     * 根据用户Id获取用户
     * @param userId
     * @return
     */
    UserRespDto getUserByUserId(Integer userId);

    /**
     * 修改密码
     * @param userReqDto
     * @return
     */
    boolean modifyPassword(UserReqDto userReqDto) throws BusinessException;

    /**
     * 用户列表
     * @return
     */
    List<UserRespDto> listUser(Integer page) throws BusinessException;

    /**
     * 获取用户列表最大页数
     * @return
     */
    Integer getMaxPage();

    /**
     * 用户修改
     * @param userReqDto
     * @return
     */
    boolean modifyUser(UserReqDto userReqDto);
}
