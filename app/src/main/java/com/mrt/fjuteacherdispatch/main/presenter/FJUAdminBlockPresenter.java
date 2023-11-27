package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.FJUAdminBlockModel;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUAdminBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUAdminBlockListener;

public class FJUAdminBlockPresenter {

    private FJUAdminBlockFragment mFragment;

    private FJUAdminBlockModel mModel;

    private FJUAdminBlockListener mListener;

    private Context mContext;

    public FJUAdminBlockPresenter(
            FJUAdminBlockFragment mFragment,
            FJUAdminBlockModel mModel,
            FJUAdminBlockListener mListener) {
        this.mFragment = mFragment;
        this.mModel = mModel;
        this.mListener = mListener;
    }

    public void setBundle(Bundle bundle) {
        if(bundle != null) {

        }
    }

    public void init() {
        this.mContext = mFragment.getActivity();
    }
}
