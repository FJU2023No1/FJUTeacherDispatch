package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import com.mrt.fjuteacherdispatch.main.view.adapter.TeacherScheduleListAdapter;
import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class FJUStudentBlockModel {

    public FJUStudentBlockModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }

    public final ObservableField<String> userEMail = new ObservableField<>();

    public TeacherScheduleListAdapter mAdapter;
}
