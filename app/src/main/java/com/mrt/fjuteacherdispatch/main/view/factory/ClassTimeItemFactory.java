package com.mrt.fjuteacherdispatch.main.view.factory;

import com.mrt.fjuteacherdispatch.main.model.data.ClassTimeType;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassTimeItemFactory {
    private static final ArrayList<MenuItem> list = new ArrayList<>(
            Arrays.asList(
                    ClassTimeType.Morning9to12.getMenuItem(),
                    ClassTimeType.Afternoon14to17.getMenuItem(),
                    ClassTimeType.Night19to22.getMenuItem()
            )
    );

    public static ArrayList<MenuItem> createItem() {
        return list;
    }
}
