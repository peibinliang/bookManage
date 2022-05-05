package com.book.manage.core.enums;

/**
 * @author liangpeibin
 * @ClassName UserTypeEnum
 * @Description
 * @since 2022/5/3 23:30
 */
public enum UserTypeEnum {
    Admin(1, "管理员"),
    User(2, "普通用户");

    private final Integer typeId;
    private final String typeName;

    UserTypeEnum(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTypeName(Integer typeId){
        return typeName;
    }
}
