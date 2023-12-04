package com.mrt.fjuteacherdispatch.main.view.factory;

import com.mrt.fjuteacherdispatch.main.model.data.ClassDegreeType;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassDegreeItemFactory {

    private static final ArrayList<MenuItem> list = new ArrayList<>(
            Arrays.asList(
                    ClassDegreeType.TocflA1.getMenuItem(),
                    ClassDegreeType.TocflA2.getMenuItem(),
                    ClassDegreeType.TocflB1.getMenuItem(),
                    ClassDegreeType.TocflB2.getMenuItem(),
                    ClassDegreeType.TocflC.getMenuItem(),
                    ClassDegreeType.TECC1.getMenuItem(),
                    ClassDegreeType.TECC2.getMenuItem(),
                    ClassDegreeType.TECC3.getMenuItem(),
                    ClassDegreeType.TECC4.getMenuItem(),
                    ClassDegreeType.HSK1.getMenuItem(),
                    ClassDegreeType.HSK2.getMenuItem(),
                    ClassDegreeType.HSK3.getMenuItem(),
                    ClassDegreeType.HSK4.getMenuItem(),
                    ClassDegreeType.HSK5.getMenuItem(),
                    ClassDegreeType.HSK6.getMenuItem()
            )
    );

    public static ArrayList<MenuItem> createItem() {
        return list;
    }
}
