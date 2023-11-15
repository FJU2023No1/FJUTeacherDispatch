package com.mrt.fjuteacherdispatch.main.model.data;

public class IdentityItem {

    private int typeID;

    private String typeName;

    public IdentityItem(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public String getTypeName() {
        return typeName;
    }
}
