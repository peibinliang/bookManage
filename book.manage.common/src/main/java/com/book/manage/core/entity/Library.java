package com.book.manage.core.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("library")
public class Library extends Model<Library> {

	private static final long serialVersionUID = 1L;

	/**
	 * 图书库Id
	 */
	@ApiModelProperty(value = "图书库Id")
	@TableId(value = "library_id",type = IdType.AUTO)
	private Integer libraryId;

	/**
	 * 图书库编号
	 */
	@ApiModelProperty(value = "图书库编号")
	@TableField("library_no")
	private String libraryNo;

	/**
	 * 图书库所属的用户
	 */
	@ApiModelProperty(value = "图书库所属的用户")
	@TableField("user_id")
	private Integer userId;

	/**
	 * 图书库名称
	 */
	@ApiModelProperty(value = "图书库名称")
	@TableField("library_name")
	private String libraryName;

	/**
	 * 是否删除：0 未删除 1 删除
	 */
	@ApiModelProperty(value = "是否删除：0 未删除 1 删除")
	@TableField("is_deleted")
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@TableField("gmt_create")
	private java.util.Date gmtCreate;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	@TableField("gmt_modify")
	private java.util.Date gmtModify;


}
