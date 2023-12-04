package com.mrt.fjuteacherdispatch.main.view.factory;

import com.mrt.fjuteacherdispatch.main.model.data.ClassSubjectType;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassSubjectItemFactory {

    private static final ArrayList<MenuItem> list = new ArrayList<>(
            Arrays.asList(
                    ClassSubjectType.Phrase.getMenuItem(),
                    ClassSubjectType.Grammar.getMenuItem(),
                    ClassSubjectType.TravelTerms.getMenuItem(),
                    ClassSubjectType.DailyLanguages.getMenuItem(),
                    ClassSubjectType.BusinessTerms.getMenuItem(),
                    ClassSubjectType.Painting.getMenuItem(),
                    ClassSubjectType.Music.getMenuItem(),
                    ClassSubjectType.Biology.getMenuItem(),
                    ClassSubjectType.Literature.getMenuItem()
            )
    );

    public static ArrayList<MenuItem> createItem() {
        return list;
    }
}
