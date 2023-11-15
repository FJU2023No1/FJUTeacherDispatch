package com.mrt.fjuteacherdispatch.main.model.data;

public enum IdentityType {

    /**
     * 未定義.
     */
    Unknown(new IdentityItem(-1, "")),

    /**
     * 學生.
     */
    Student(new IdentityItem(1, "學生")),

    /**
     * 老師.
     */
    Teacher(new IdentityItem(2, "老師")),

    /**
     * 管理者.
     */
    Admin(new IdentityItem(3, "管理者"));

    private IdentityItem identityItem;

    IdentityType(IdentityItem identityItem) {
        this.identityItem = identityItem;
    }

    public IdentityItem getItem() {
        return identityItem;
    }

    public static IdentityType getByteValue(int type) {
        for (IdentityType identityType : IdentityType.values()) {
            if (identityType.identityItem.getTypeID() == type) {
                return identityType;
            }
        }
        return Unknown;
    }

    public static IdentityType getByteValueName(String typeName) {
        for (IdentityType identityType : IdentityType.values()) {
            if (identityType.identityItem.getTypeName().equals(typeName)) {
                return identityType;
            }
        }
        return Unknown;
    }
}