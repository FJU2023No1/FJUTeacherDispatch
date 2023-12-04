package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.SettingModel;
import com.mrt.fjuteacherdispatch.main.view.SettingActivity;

public class SettingPresenter {

    private SettingActivity mActivity;

    private SettingModel mModel;

    public SettingPresenter (
            SettingActivity mActivity,
            SettingModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void setBundle(Bundle bundle) {

        if (bundle != null) {
            if (bundle.getSerializable(SettingActivity.FIELD_USER_EMAIL_DATA) != null) {
                mModel.userMail.set(String.valueOf(bundle.getSerializable(SettingActivity.FIELD_USER_EMAIL_DATA)));
            }
        }
    }

    public void init() {
    }
}
