package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.FJUTeacherBlockModel;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUTeacherBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUTeacherBlockListener;

public class FJUTeacherBlockPresenter {

    private FJUTeacherBlockFragment mFragment;

    private FJUTeacherBlockModel mModel;

    private FJUTeacherBlockListener mListener;

    private Context mContext;

    public FJUTeacherBlockPresenter(
            FJUTeacherBlockFragment mFragment,
            FJUTeacherBlockModel mModel,
            FJUTeacherBlockListener mListener) {
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
