package com.book.manage.core.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("user")
public class User extends Model<User> {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户Id
	 */
	@ApiModelProperty(value = "用户Id")
	@TableId(value = "user_id",type = IdType.AUTO)
	private Integer userId;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	@TableField("user_name")
	private String userName;

	/**
	 * 用户昵称
	 */
	@ApiModelProperty(value = "用户昵称")
	@TableField("nick_name")
	private String nickName;

	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码")
	@TableField("phone")
	private String phone;

	/**
	 * 邮编
	 */
	@ApiModelProperty(value = "邮编")
	@TableField("email")
	private String email;

	/**
	 * 用户类型：1  管理员  2 普通用户
	 */
	@ApiModelProperty(value = "用户类型：1  管理员  2 普通用户")
	@TableField("user_type")
	private Integer userType;

	/**
	 * 用户类型名称
	 */
	@ApiModelProperty(value = "用户类型名称")
	@TableField("user_type_name")
	private String userTypeName;

	/**
	 * 用户密码
	 */
	@ApiModelProperty(value = "用户密码")
	@TableField("password")
	private String password;

	/**
	 * a
	 */
	@ApiModelProperty(value = "a")
	@TableField("is_deleted")
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@TableField("gmt_create")
	private java.util.Date gmtCreate;

	/**
	 * 最后修改时间
	 */
	@ApiModelProperty(value = "最后修改时间")
	@TableField("gmt_modify")
	private java.util.Date gmtModify;

}
