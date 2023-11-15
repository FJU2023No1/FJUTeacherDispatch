package com.mrt.fjuteacherdispatch.main.view.factory;

import com.mrt.fjuteacherdispatch.main.model.data.GenderType;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class GenderItemFactory {

    private static final ArrayList<MenuItem> list = new ArrayList<>(
            Arrays.asList(
                    GenderType.Male.getMenuItem(),
                    GenderType.Female.getMenuItem()
            )
    );

    public static ArrayList<MenuItem> createItem() {
        return list;
    }
}
