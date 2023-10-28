package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Context;
import android.widget.Toast;

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

    public void onGoToStudent() {
        Toast.makeText(mActivity, "Student", Toast.LENGTH_LONG).show();
    }

    public void onGoToTeacher() {
        Toast.makeText(mActivity, "Teacher", Toast.LENGTH_LONG).show();
    }

    public void onGoToAdministrator() {
        Toast.makeText(mActivity, "Admin", Toast.LENGTH_LONG).show();
    }
}
