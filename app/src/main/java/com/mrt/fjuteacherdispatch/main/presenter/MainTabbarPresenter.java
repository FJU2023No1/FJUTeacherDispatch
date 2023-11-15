package com.mrt.fjuteacherdispatch.main.presenter;

import com.mrt.fjuteacherdispatch.main.model.MainTabbarModel;
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

    public void init() {
    }

    public void tabbarItemOnClick(int index, int old) {

    }
}
