package com.book.manage.core.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LibraryLog extends Model<LibraryLog> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键 序号
	 */
	@ApiModelProperty(value = "主键 序号")
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;

	/**
	 * 图书库Id
	 */
	@ApiModelProperty(value = "图书库Id")
	@TableField("library_id")
	private Integer libraryId;

	/**
	 * 书籍Id
	 */
	@ApiModelProperty(value = "书籍Id")
	@TableField("book_id")
	private Integer bookId;

	/**
	 * 修改类型：1 增加 2 删除 3 修改 
	 */
	@ApiModelProperty(value = "修改类型：1 增加 2 删除 3 修改 ")
	@TableField("modify_type")
	private Integer modifyType;

	@TableField("gmt_create")
	private java.util.Date gmtCreate;


}
