package com.mrt.fjuteacherdispatch.main.view.factory;

import com.mrt.fjuteacherdispatch.main.model.data.ClassLocationType;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassLocationItemFactory {
    private static final ArrayList<MenuItem> list = new ArrayList<>(
            Arrays.asList(
                    ClassLocationType.OnLine.getMenuItem(),
                    ClassLocationType.School.getMenuItem(),
                    ClassLocationType.DiscussionRoom.getMenuItem(),
                    ClassLocationType.ProfessionalClassroom.getMenuItem(),
                    ClassLocationType.Cafe.getMenuItem(),
                    ClassLocationType.Home.getMenuItem()
            )
    );

    public static ArrayList<MenuItem> createItem() {
        return list;
    }
}