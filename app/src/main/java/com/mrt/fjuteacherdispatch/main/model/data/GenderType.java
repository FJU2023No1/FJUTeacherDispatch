package com.mrt.fjuteacherdispatch.main.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

public enum GenderType {

    /**
     * 未定義.
     */
    Unknown(new MenuItem(-1, "")),

    /**
     * 男生.
     */
    Male(new MenuItem(1, "男生")),

    /**
     * 女生.
     */
    Female(new MenuItem(2, "女生"));

    private MenuItem menuItem;

    GenderType(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static GenderType getByteValue(int type) {
        for (GenderType genderType : GenderType.values()) {
            if (genderType.menuItem.getItemId() == type) {
                return genderType;
            }
        }
        return Unknown;
    }

    public static GenderType getByteValueName(String typeName) {
        for (GenderType genderType : GenderType.values()) {
            if (genderType.menuItem.getItemName().equals(typeName)) {
                return genderType;
            }
        }
        return Unknown;
    }
}
