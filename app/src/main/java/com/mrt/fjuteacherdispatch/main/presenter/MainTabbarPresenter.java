package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;
import android.util.Log;

import com.mrt.fjuteacherdispatch.main.model.MainTabbarModel;
import com.mrt.fjuteacherdispatch.main.view.FJUTDLoginWebActivity;
import com.mrt.fjuteacherdispatch.main.view.MainTabbarActivity;
import com.mrt.fjuteacherdispatch.main.view.listener.MainTabbarListener;

public class MainTabbarPresenter {

    private MainTabbarActivity mActivity;
    private MainTabbarModel mModel;
    private MainTabbarListener mListener;

    public MainTabbarPresenter(
            MainTabbarActivity mActivity,
            MainTabbarModel mModel,
            MainTabbarListener mListener) {
        this.mActivity = mActivity;
        this.mModel = mModel;
        this.mListener = mListener;
    }

    public void setBundle(Bundle bundle) {

        if (bundle != null) {
            if (bundle.getSerializable(FJUTDLoginWebActivity.FIELD_USER_TYPE_DATA) != null) {
                mModel.userIdentityID.set(String.valueOf(bundle.getSerializable(FJUTDLoginWebActivity.FIELD_USER_TYPE_DATA)));

                Log.e("TEST", mModel.userIdentityID.get().toString());
            }
        }
    }

    public void init() {
    }

    public void tabbarItemOnClick(int index, int old) {

    }
}
