package com.book.manage.core.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangpeibin
 * @ClassName UserReqDto
 * @Description 用户请求对象
 * @since 2022/5/2 20:25
 */
@Data
public class UserReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String email;

    /**
     * 用户类型：1  管理员  2 普通用户
     */
    @ApiModelProperty(value = "用户类型：1  管理员  2 普通用户")
    private Integer userType;

    /**
     * 用户类型名称
     */
    @ApiModelProperty(value = "用户类型名称")
    private String userTypeName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码")
    private String newPassword;

    /**
     * a
     */
    @ApiModelProperty(value = "a")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private Date gmtModify;
}
