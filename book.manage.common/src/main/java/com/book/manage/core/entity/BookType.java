package com.book.manage.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BookType extends Model<BookType> {

	private static final long serialVersionUID = 1L;

	/**
	 * 类型Id
	 */
	@ApiModelProperty(value = "类型Id")
	@TableId(value = "type_id",type = IdType.AUTO)
	private Integer typeId;

	/**
	 * 类型名称
	 */
	@ApiModelProperty(value = "类型名称")
	@TableField("type_name")
	private String typeName;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	@TableField("note")
	private String note;

	/**
	 * 所属图书库
	 */
	@ApiModelProperty(value = "所属图书库")
	@TableField("library_id")
	private Integer libraryId;

	/**
	 * 是否删除：0 未删除 1 已删除
	 */
	@ApiModelProperty(value = "是否删除：0 未删除 1 已删除")
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
