package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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

    public void setBundle(Bundle bundle) {
        if(bundle!=null) {
            mModel.userIdentityID.set(String.valueOf(bundle.getInt(HomePageFragment.FIELD_USER_TYPE)));
        }
    }

    public void init() {
        mFragment.loadFragment(Integer.parseInt(mModel.userIdentityID.get().toString()));
    }

}