package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class TeacherAddScheduleModel {

    public TeacherAddScheduleModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }

    public final ObservableField<String> userMail = new ObservableField<>();
}
