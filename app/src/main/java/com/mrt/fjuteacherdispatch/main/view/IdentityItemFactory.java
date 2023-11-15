package com.mrt.fjuteacherdispatch.main.view;

import com.mrt.fjuteacherdispatch.main.model.data.IdentityItem;
import com.mrt.fjuteacherdispatch.main.model.data.IdentityType;

import java.util.ArrayList;
import java.util.Arrays;

public class IdentityItemFactory {

    private static final ArrayList<IdentityItem> list = new ArrayList<>(
            Arrays.asList(
                    IdentityType.Student.getItem(),
                    IdentityType.Teacher.getItem(),
                    IdentityType.Admin.getItem()
            )
    );

    public static ArrayList<IdentityItem> createItem() {
        return list;
    }
}
