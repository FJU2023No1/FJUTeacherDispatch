package com.mrt.fjuteacherdispatch.main.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

public enum ClassTimeType {

    /**
     * 未定義.
     */
    Unknown(new MenuItem(-1, "")),

    /**
     * 上午 9~12.
     */
    Morning9to12(new MenuItem(1, "上午 9:00 ~ 12:00")),

    /**
     * 上午 14~17.
     */
    Afternoon14to17(new MenuItem(2, "下午 14:00 ~ 17:00")),

    /**
     * 晚上 19~22.
     */
    Night19to22(new MenuItem(3, "晚上 19:00 ~ 22:00"));

    private MenuItem menuItem;

    ClassTimeType(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static ClassTimeType getByteValue(int type) {
        for (ClassTimeType classTimeType : ClassTimeType.values()) {
            if (classTimeType.menuItem.getItemId() == type) {
                return classTimeType;
            }
        }
        return Unknown;
    }

    public static ClassTimeType getByteValueName(String typeName) {
        for (ClassTimeType classTimeType : ClassTimeType.values()) {
            if (classTimeType.menuItem.getItemName().equals(typeName)) {
                return classTimeType;
            }
        }
        return Unknown;
    }
}
