package com.book.manage.core.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liangpeibin
 * @ClassName BookReqDto
 * @Description 图书请求对象
 * @since 2022/5/6 20:23
 */
@Data
public class BookReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 书籍Id
     */
    @ApiModelProperty(value = "书籍Id")
    private Integer bookId;

    /**
     * 书籍名称
     */
    @ApiModelProperty(value = "书籍名称")
    private String bookName;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String author;

    /**
     * 书籍类型
     */
    @ApiModelProperty(value = "书籍类型")
    private Integer type;

    /**
     * 书籍出版社
     */
    @ApiModelProperty(value = "书籍出版社")
    private String press;

    /**
     * 出版时间
     */
    @ApiModelProperty(value = "出版时间")
    private String gmtPublication;

    /**
     * ISBN号码
     */
    @ApiModelProperty(value = "ISBN号码")
    private String isbn;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;

    /**
     * 所属图书库
     */
    @ApiModelProperty(value = "所属图书库")
    private Integer libraryId;

    /**
     * 是否删除：0 未删除 1 已删除
     */
    @ApiModelProperty(value = "是否删除：0 未删除 1 已删除")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private java.util.Date gmtCreate;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private java.util.Date gmtModify;

    /**
     * 搜索词
     */
    @ApiModelProperty(value = "搜索词")
    private String search;
}
