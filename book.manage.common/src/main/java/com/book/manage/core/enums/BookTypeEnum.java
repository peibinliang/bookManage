package com.book.manage.core.enums;

import lombok.AllArgsConstructor;

/**
 * @author liangpeibin
 * @ClassName BookTypeEnum
 * @Description 书籍类型枚举类
 * @since 2022/5/7 11:25
 */
@AllArgsConstructor
public enum BookTypeEnum {
    Novel(1,"小说"),
    Biography(2,"传记"),
    Prose(3,"散文"),
    Informal_Essay(4,"随笔"),
    Reference_Book(5,"工具书");

    private final Integer typeId;
    private final String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public static String getTypeNameByTypeId(Integer typeId){
        for (BookTypeEnum bookTypeEnum : values()){
            if (bookTypeEnum.typeId == typeId){
                return bookTypeEnum.typeName;
            }
        }
        return null;
    }

    public static Integer getTypeIdByTypeName(String typeName){
        for (BookTypeEnum bookTypeEnum : values()){
            if (bookTypeEnum.typeName.equals(typeName)){
                return bookTypeEnum.typeId;
            }
        }
        return null;
    }
}
