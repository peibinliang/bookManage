package com.book.manage.core.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liangpeibin
 * @ClassName LibraryReqDto
 * @Description 图书库请求对象
 * @since 2022/5/4 17:29
 */
@Data
public class LibraryReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图书库Id
     */
    @ApiModelProperty(value = "图书库Id")
    private Integer libraryId;

    /**
     * 图书库编号
     */
    @ApiModelProperty(value = "图书库编号")
    private String libraryNo;

    /**
     * 图书库所属的用户
     */
    @ApiModelProperty(value = "图书库所属的用户")
    private Integer userId;

    /**
     * 图书库名称
     */
    @ApiModelProperty(value = "图书库名称")
    private String libraryName;

    /**
     * 是否删除：0 未删除 1 删除
     */
    @ApiModelProperty(value = "是否删除：0 未删除 1 删除")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private java.util.Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private java.util.Date gmtModify;
}
