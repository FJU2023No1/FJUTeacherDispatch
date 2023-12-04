package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import com.mrt.fjuteacherdispatch.tool.ClickLock;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class StudentAddDemandModel {

    public StudentAddDemandModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }

    public List<MenuItem> classTimelist = new ArrayList<>();

    public List<MenuItem> classLocationlist = new ArrayList<>();

    public List<MenuItem> classSubjectlist = new ArrayList<>();

    public List<MenuItem> classDegreelist = new ArrayList<>();

    public final ObservableField<String> userMail = new ObservableField<>();

    /**
     * 上課日期.
     */
    public final ObservableField<String> classDateText = new ObservableField<>("");

    /**
     * 上課時段.
     */
    public final ObservableField<String> classTimeText = new ObservableField<>("");

    /**
     * 上課地點.
     */
    public final ObservableField<String> classLocationText = new ObservableField<>("");

    /**
     * 希望待遇.
     */
    public final ObservableField<String> classContactText = new ObservableField<>("");

    /**
     * 授課科目.
     */
    public final ObservableField<String> classSubjectText = new ObservableField<>("");

    /**
     * 中文程度.
     */
    public final ObservableField<String> classDegreeText = new ObservableField<>("");
}
