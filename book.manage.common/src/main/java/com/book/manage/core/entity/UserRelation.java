package com.book.manage.core.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRelation extends Model<UserRelation> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键 序号
	 */
	@ApiModelProperty(value = "主键 序号")
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户Id
	 */
	@ApiModelProperty(value = "用户Id")
	@TableField("user_id")
	private Integer userId;

	/**
	 * 图书库Id
	 */
	@ApiModelProperty(value = "图书库Id")
	@TableField("library_id")
	private Integer libraryId;


}
