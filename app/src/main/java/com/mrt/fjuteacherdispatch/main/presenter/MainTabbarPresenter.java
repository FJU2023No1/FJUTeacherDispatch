package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;
import android.util.Log;

import com.mrt.fjuteacherdispatch.main.model.MainTabbarModel;
import com.mrt.fjuteacherdispatch.main.view.FJUTDLoginWebActivity;
import com.mrt.fjuteacherdispatch.main.view.MainTabbarActivity;
import com.mrt.fjuteacherdispatch.main.view.adapter.BaseFragmentPagerAdapter;
import com.mrt.fjuteacherdispatch.main.view.fragment.HomePageFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.MainTabbarListener;

public class MainTabbarPresenter {

    private MainTabbarActivity mActivity;
    private MainTabbarModel mModel;
    private MainTabbarListener mListener;

    private BaseFragmentPagerAdapter mAdapter;

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
            }

            if (bundle.getSerializable(MainTabbarActivity.FIELD_USER_EMAIL_DATA) != null) {
                mModel.userMail.set(String.valueOf(bundle.getSerializable(MainTabbarActivity.FIELD_USER_EMAIL_DATA)));
            }
        }
    }

    public void init() {
    }

    public void tabbarItemOnClick(int index, int old) {
        mModel.getNavigationController().setSelect(0, false);

        if (index == 1) {
            mListener.onNotification();
        } else if (index == 3) {
            mListener.onAddJob();
        } else if (index == 5) {
            mListener.onSettings();
        }
    }
}
