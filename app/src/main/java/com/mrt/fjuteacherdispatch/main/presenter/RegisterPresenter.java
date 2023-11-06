package com.mrt.fjuteacherdispatch.main.presenter;

import com.mrt.fjuteacherdispatch.main.model.RegisterModel;
import com.mrt.fjuteacherdispatch.main.view.RegisterActivity;

public class RegisterPresenter {

    private RegisterActivity mActivity;

    private RegisterModel mModel;

    public RegisterPresenter (RegisterActivity mActivity,
                              RegisterModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void init() {
    }
}
