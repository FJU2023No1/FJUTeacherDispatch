package com.mrt.fjuteacherdispatch.tool.menu.presenter;

import android.content.Context;

import com.mrt.fjuteacherdispatch.tool.menu.model.MenuDialogModel;
import com.mrt.fjuteacherdispatch.tool.menu.view.fragment.MenuDialogFragment;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

public class MenuDialogPresenter {

    private Context mContext;

    private MenuDialogModel mModel;

    private MenuDialogFragment mFragment;

    private MenuListener mListener;

    public MenuDialogPresenter(Context mContext,
                               MenuDialogModel mModel,
                               MenuDialogFragment mFragment,
                               MenuListener mListener) {
        this.mContext = mContext;
        this.mModel = mModel;
        this.mFragment = mFragment;
        this.mListener = mListener;
    }

    public void init() {
    }

    public void onCancel() {
        mListener.onCancel();
        mFragment.dismissAllowingStateLoss();
    }
}
