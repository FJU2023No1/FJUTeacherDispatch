package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.NotificationModel;
import com.mrt.fjuteacherdispatch.main.view.NotificationActivity;

public class NotificationPresenter {

    private NotificationActivity mActivity;

    private NotificationModel mModel;

    public NotificationPresenter (
            NotificationActivity mActivity,
            NotificationModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void setBundle(Bundle bundle) {

        if (bundle != null) {
            if (bundle.getSerializable(NotificationActivity.FIELD_USER_EMAIL_DATA) != null) {
                mModel.userMail.set(String.valueOf(bundle.getSerializable(NotificationActivity.FIELD_USER_EMAIL_DATA)));
            }
        }
    }

    public void init() {
    }
}
