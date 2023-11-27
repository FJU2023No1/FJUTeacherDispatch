package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.os.Bundle;

import com.mrt.fjuteacherdispatch.main.model.FJUStudentBlockModel;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUStudentBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUStudentBlockListener;

public class FJUStudentBlockPresenter {

    private FJUStudentBlockFragment mFragment;

    private FJUStudentBlockModel mModel;

    private FJUStudentBlockListener mListener;

    private Context mContext;

    public FJUStudentBlockPresenter(
            FJUStudentBlockFragment mFragment,
            FJUStudentBlockModel mModel,
            FJUStudentBlockListener mListener) {
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
