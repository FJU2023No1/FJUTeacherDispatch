package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;

import com.mrt.fjuteacherdispatch.main.model.HomePageModel;
import com.mrt.fjuteacherdispatch.main.view.fragment.HomePageFragment;


public class HomePagePresenter {
    private Context mContext;
    private HomePageModel mModel;
    private HomePageFragment mFragment;

    public HomePagePresenter(Context mContext,
                             HomePageModel mModel,
                             HomePageFragment mFragment) {
        this.mContext = mContext;
        this.mModel = mModel;
        this.mFragment = mFragment;

    }

    public void init() {
    }


}