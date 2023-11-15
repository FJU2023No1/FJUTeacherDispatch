package com.mrt.fjuteacherdispatch.main.view.factory;

import com.mrt.fjuteacherdispatch.main.model.data.CountryType;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class CountryItemFactory {

    private static final ArrayList<MenuItem> list = new ArrayList<>(
            Arrays.asList(
                    CountryType.Asia.getMenuItem(),
                    CountryType.NorthAmerica.getMenuItem(),
                    CountryType.SouthAmerica.getMenuItem(),
                    CountryType.Oceania.getMenuItem(),
                    CountryType.Africa.getMenuItem(),
                    CountryType.Europe.getMenuItem(),
                    CountryType.Antarctica.getMenuItem()
            )
    );

    public static ArrayList<MenuItem> createItem() {
        return list;
    }
}
