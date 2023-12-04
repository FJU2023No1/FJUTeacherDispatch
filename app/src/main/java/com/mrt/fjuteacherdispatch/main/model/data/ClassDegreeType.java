package com.mrt.fjuteacherdispatch.main.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

public enum ClassDegreeType {

    /**
     * 未定義.
     */
    Unknown(new MenuItem(-1, "")),

    /**
     * Tocfl漢拼階段 A1.
     */
    TocflA1(new MenuItem(1, "Tocfl漢拼階段 A1")),

    /**
     * Tocfl漢拼階段 A2.
     */
    TocflA2(new MenuItem(2, "Tocfl漢拼階段 A2")),

    /**
     * Tocfl漢拼階段 B1.
     */
    TocflB1(new MenuItem(3, "Tocfl漢拼階段 B1")),

    /**
     * Tocfl漢拼階段 B2.
     */
    TocflB2(new MenuItem(4, "Tocfl漢拼階段 B2")),

    /**
     * Tocfl漢拼階段 C.
     */
    TocflC(new MenuItem(5, "Tocfl漢拼階段 C")),

    /**
     * TECC 1級.
     */
    TECC1(new MenuItem(6, "TECC 1級")),

    /**
     * TECC 2級.
     */
    TECC2(new MenuItem(7, "TECC 2級")),

    /**
     * TECC 3級.
     */
    TECC3(new MenuItem(8, "TECC 3級")),

    /**
     * TECC 4級.
     */
    TECC4(new MenuItem(9, "TECC 4級")),

    /**
     * HSK 1級.
     */
    HSK1(new MenuItem(10, "HSK 1級")),

    /**
     * HSK 2級.
     */
    HSK2(new MenuItem(11, "HSK 2級")),

    /**
     * HSK 3級.
     */
    HSK3(new MenuItem(12, "HSK 3級")),

    /**
     * HSK 4級.
     */
    HSK4(new MenuItem(13, "HSK 4級")),

    /**
     * HSK 5級.
     */
    HSK5(new MenuItem(14, "HSK 5級")),

    /**
     * HSK 6級.
     */
    HSK6(new MenuItem(15, "HSK 6級"));

    private MenuItem menuItem;

    ClassDegreeType(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static ClassDegreeType getByteValue(int type) {
        for (ClassDegreeType classDegreeType : ClassDegreeType.values()) {
            if (classDegreeType.menuItem.getItemId() == type) {
                return classDegreeType;
            }
        }
        return Unknown;
    }

    public static ClassDegreeType getByteValueName(String typeName) {
        for (ClassDegreeType classDegreeType : ClassDegreeType.values()) {
            if (classDegreeType.menuItem.getItemName().equals(typeName)) {
                return classDegreeType;
            }
        }
        return Unknown;
    }
}