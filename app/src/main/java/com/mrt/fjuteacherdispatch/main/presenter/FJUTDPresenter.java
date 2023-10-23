package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;

import com.mrt.fjuteacherdispatch.main.model.FJUTDModel;
import com.mrt.fjuteacherdispatch.main.view.FJUTDActivity;

public class FJUTDPresenter {

    private FJUTDActivity mActivity;

    private FJUTDModel mModel;

    public FJUTDPresenter (FJUTDActivity mActivity,
                           FJUTDModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void init() {

    }
}
