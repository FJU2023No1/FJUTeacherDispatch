package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.TeacherAddScheduleModel;
import com.mrt.fjuteacherdispatch.main.view.TeacherAddScheduleActivity;

public class TeacherAddSchedulePresenter {

    private TeacherAddScheduleActivity mActivity;

    private TeacherAddScheduleModel mModel;

    public TeacherAddSchedulePresenter (
            TeacherAddScheduleActivity mActivity,
            TeacherAddScheduleModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void setBundle(Bundle bundle) {

        if (bundle != null) {
            if (bundle.getSerializable(TeacherAddScheduleActivity.FIELD_USER_EMAIL_DATA) != null) {
                mModel.userMail.set(String.valueOf(bundle.getSerializable(TeacherAddScheduleActivity.FIELD_USER_EMAIL_DATA)));
            }
        }
    }

    public void init() {
    }
}
