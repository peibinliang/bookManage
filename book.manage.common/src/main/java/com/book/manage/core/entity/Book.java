package com.book.manage.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("书籍实体对象")
@TableName("book")
public class Book extends Model<Book> {

	private static final long serialVersionUID = 1L;

	/**
	 * 书籍Id
	 */
	@ApiModelProperty(value = "书籍Id")
	@TableId(value = "book_id",type = IdType.AUTO)
	private Integer bookId;

	/**
	 * 书籍名称
	 */
	@ApiModelProperty(value = "书籍名称")
	@TableField("book_name")
	private String bookName;

	/**
	 * 作者
	 */
	@ApiModelProperty(value = "作者")
	@TableField("author")
	private String author;

	/**
	 * 书籍类型
	 */
	@ApiModelProperty(value = "书籍类型")
	@TableField("type")
	private Integer type;

	/**
	 * 书籍出版社
	 */
	@ApiModelProperty(value = "书籍出版社")
	@TableField("press")
	private String press;

	/**
	 * 出版时间
	 */
	@ApiModelProperty(value = "出版时间")
	@TableField("gmt_publication")
	private String gmtPublication;

	/**
	 * ISBN号码
	 */
	@ApiModelProperty(value = "ISBN号码")
	@TableField("ISBN")
	private String isbn;

	/**
	 * 库存
	 */
	@ApiModelProperty(value = "库存")
	@TableField("stock")
	private Integer stock;

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
	private String gmtCreate;

	/**
	 * 最后修改时间
	 */
	@ApiModelProperty(value = "最后修改时间")
	@TableField("gmt_modify")
	private String gmtModify;


}
