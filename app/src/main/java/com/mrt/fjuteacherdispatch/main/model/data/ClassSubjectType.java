package com.mrt.fjuteacherdispatch.main.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

public enum ClassSubjectType {

    /**
     * 未定義.
     */
    Unknown(new MenuItem(-1, "")),

    /**
     * 慣用語.
     */
    Phrase(new MenuItem(1, "慣用語")),

    /**
     * 文法.
     */
    Grammar(new MenuItem(2, "文法")),

    /**
     * 旅遊用語.
     */
    TravelTerms(new MenuItem(3, "旅遊用語")),

    /**
     * 日常用語.
     */
    DailyLanguages(new MenuItem(4, "日常用語")),

    /**
     * 商業用語.
     */
    BusinessTerms(new MenuItem(5, "商業用語")),

    /**
     * 繪畫.
     */
    Painting(new MenuItem(6, "繪畫")),

    /**
     * 音樂.
     */
    Music(new MenuItem(7, "音樂")),

    /**
     * 生物.
     */
    Biology(new MenuItem(8, "生物")),

    /**
     * 文學.
     */
    Literature(new MenuItem(9, "文學"));

    private MenuItem menuItem;

    ClassSubjectType(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static ClassSubjectType getByteValue(int type) {
        for (ClassSubjectType classSubjectType : ClassSubjectType.values()) {
            if (classSubjectType.menuItem.getItemId() == type) {
                return classSubjectType;
            }
        }
        return Unknown;
    }

    public static ClassSubjectType getByteValueName(String typeName) {
        for (ClassSubjectType classSubjectType : ClassSubjectType.values()) {
            if (classSubjectType.menuItem.getItemName().equals(typeName)) {
                return classSubjectType;
            }
        }
        return Unknown;
    }
}

