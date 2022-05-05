package com.book.manage.sample.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.book.manage.core.Mapper.UserMapper;
import com.book.manage.core.dto.req.UserReqDto;
import com.book.manage.core.dto.resp.UserRespDto;
import com.book.manage.core.entity.User;
import com.book.manage.core.enums.UserStateCode;
import com.book.manage.core.enums.UserTypeEnum;
import com.book.manage.core.exception.BusinessException;
import com.book.manage.core.utils.UserUtils;
import com.book.manage.sample.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author liangpeibin
 * @ClassName UserServiceImpl
 * @Description 用户服务实现类
 * @since 2022/4/12 20:10
 */
@Service("userService")
@DubboService
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 新增用户
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean saveUser(UserReqDto userReqDto) throws BusinessException {
        if (Objects.nonNull(userMapper.getUserByUserName(userReqDto.getUserName()))) {
            throw new BusinessException(UserStateCode.BU10001);
        }

        if (Objects.isNull(userReqDto.getUserType())) {
            userReqDto.setUserType(UserTypeEnum.User.getTypeId());
            userReqDto.setUserTypeName(UserTypeEnum.User.getTypeName());
        } else {
            userReqDto.setUserTypeName(userReqDto.getUserType() == 1 ? UserTypeEnum.Admin.getTypeName() : UserTypeEnum.User.getTypeName());
        }
        return userMapper.insert(BeanUtil.toBean(userReqDto, User.class)) > 0;
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public UserRespDto login(UserReqDto user) throws BusinessException {
        UserRespDto userRespDto = userMapper.getUserByUserName(user.getUserName());
        if (Objects.isNull(userRespDto)) {
            throw new BusinessException(UserStateCode.BU10002);
        }
        if (!userRespDto.getPassword().equals(user.getPassword())) {
            throw new BusinessException(UserStateCode.BU10003);
        }
        return userRespDto;
    }

    /**
     * 忘记密码
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean forgerPassword(UserReqDto userReqDto) throws BusinessException {
        UserRespDto user = userMapper.getUserByUserName(userReqDto.getUserName());
        if (Objects.isNull(user)) {
            throw new BusinessException(UserStateCode.BU10002);
        } else if (!UserUtils.CorrectPhoneNumber(userReqDto.getPhone())) {
            throw new BusinessException(UserStateCode.BU10005);
        } else if (!user.getPhone().equals(userReqDto.getPhone())) {
            throw new BusinessException(UserStateCode.BU10004);
        }
        user.setPassword(userReqDto.getPassword());
        return userMapper.updateById(BeanUtil.toBean(userReqDto, User.class)) > 0;
    }

    /**
     * 根据用户Id获取用户
     *
     * @param userId
     * @return
     */
    @Override
    public UserRespDto getUserByUserId(Integer userId) {
        return BeanUtil.toBean(userMapper.selectById(userId),UserRespDto.class);
    }

    /**
     * 修改密码
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean modifyPassword(UserReqDto userReqDto) throws BusinessException {
        UserRespDto user = userMapper.getUserByUserName(userReqDto.getUserName());
        if (Objects.isNull(user)){
            throw new BusinessException(UserStateCode.BU10002);
        }
        if (!user.getPassword().equals(userReqDto.getPassword())){
            throw new BusinessException(UserStateCode.BU10006);
        }
        user.setPassword(userReqDto.getNewPassword());
        return userMapper.updateById(BeanUtil.toBean(user,User.class))>0;
    }

    /**
     * 用户列表
     *
     * @return
     */
    @Override
    public List<UserRespDto> listUser(Integer page) throws BusinessException {
        Integer start = 5*(page-1);
        List<UserRespDto> userList = userMapper.listUser(start);
        if (CollectionUtils.isEmpty(userList)){
            throw new BusinessException(UserStateCode.BU10007);
        }
        return userList;
    }

    /**
     * 获取用户列表最大页数
     *
     * @return
     */
    @Override
    public Integer getMaxPage() {
        Integer size = userMapper.getUserListSize();
        return size%5>0?(size/5)+1:size/5;
    }

    /**
     * 用户修改
     *
     * @param userReqDto
     * @return
     */
    @Override
    public boolean modifyUser(UserReqDto userReqDto) {

        return userMapper.updateById(BeanUtil.toBean(userReqDto,User.class))>0;
    }
}
