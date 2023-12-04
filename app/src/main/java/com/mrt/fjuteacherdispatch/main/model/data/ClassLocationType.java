package com.mrt.fjuteacherdispatch.main.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

public enum ClassLocationType {

    /**
     * 未定義.
     */
    Unknown(new MenuItem(-1, "")),

    /**
     * 線上.
     */
    OnLine(new MenuItem(1, "線上教授")),

    /**
     * 學校.
     */
    School(new MenuItem(2, "學校")),

    /**
     * 討論室.
     */
    DiscussionRoom(new MenuItem(2, "討論室")),

    /**
     * 專業教室.
     */
    ProfessionalClassroom(new MenuItem(2, "專業教室")),

    /**
     * 咖啡廳.
     */
    Cafe(new MenuItem(3, "咖啡廳")),

    /**
     * 住家.
     */
    Home(new MenuItem(2, "住家"));

    private MenuItem menuItem;

    ClassLocationType(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static ClassLocationType getByteValue(int type) {
        for (ClassLocationType classLocationType : ClassLocationType.values()) {
            if (classLocationType.menuItem.getItemId() == type) {
                return classLocationType;
            }
        }
        return Unknown;
    }

    public static ClassLocationType getByteValueName(String typeName) {
        for (ClassLocationType classLocationType : ClassLocationType.values()) {
            if (classLocationType.menuItem.getItemName().equals(typeName)) {
                return classLocationType;
            }
        }
        return Unknown;
    }
}
