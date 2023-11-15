package com.mrt.fjuteacherdispatch.main.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

public enum CountryType {

    /**
     * 未定義.
     */
    Unknown(new MenuItem(-1, "")),

    /**
     * 亞洲.
     */
    Asia(new MenuItem(1, "亞洲")),

    /**
     * 北美洲.
     */
    NorthAmerica(new MenuItem(2, "北美洲")),

    /**
     * 南美洲.
     */
    SouthAmerica(new MenuItem(3, "南美洲")),

    /**
     * 大洋洲.
     */
    Oceania(new MenuItem(4, "大洋洲")),

    /**
     * 非洲.
     */
    Africa(new MenuItem(5, "非洲")),

    /**
     * 歐洲.
     */
    Europe(new MenuItem(6, "歐洲")),

    /**
     * 南極洲.
     */
    Antarctica(new MenuItem(7, "南極洲")),;

    private MenuItem menuItem;

    CountryType(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static CountryType getByteValue(int type) {
        for (CountryType countryType : CountryType.values()) {
            if (countryType.menuItem.getItemId() == type) {
                return countryType;
            }
        }
        return Unknown;
    }

    public static CountryType getByteValueName(String typeName) {
        for (CountryType countryType : CountryType.values()) {
            if (countryType.menuItem.getItemName().equals(typeName)) {
                return countryType;
            }
        }
        return Unknown;
    }
}
