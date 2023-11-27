package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjutdAppActivityLoginWebBinding;
import com.mrt.fjuteacherdispatch.main.model.FJUTDLoginWebModel;
import com.mrt.fjuteacherdispatch.main.presenter.FJUTDLoginWebPresenter;

public class FJUTDLoginWebActivity extends AppCompatActivity {

    private FjutdAppActivityLoginWebBinding binding;

    private FJUTDLoginWebPresenter mPresenter;

    private FJUTDLoginWebModel mModel;

    public static void startActivity(
            Activity activity,
            boolean isFinish
    ) {
        Intent intent = new Intent(activity, FJUTDLoginWebActivity.class);
        activity.startActivity(intent);
        if (isFinish) {
            activity.finish();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.fjutd_app_activity_login_web
        );
        mModel = new FJUTDLoginWebModel();
        mPresenter = new FJUTDLoginWebPresenter(this, mModel);

        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        mPresenter.init();
    }
}
