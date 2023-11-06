package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjutdAppActivityRegisterBinding;
import com.mrt.fjuteacherdispatch.main.model.RegisterModel;
import com.mrt.fjuteacherdispatch.main.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity {

    private FjutdAppActivityRegisterBinding binding;

    private RegisterPresenter mPresenter;

    private RegisterModel mModel;

    public static void startActivity(
            Activity activity,
            boolean isFinish
    ) {
        Intent intent = new Intent(activity, RegisterActivity.class);
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
                R.layout.fjutd_app_activity_register
        );
        mModel = new RegisterModel();
        mPresenter = new RegisterPresenter(this, mModel);

        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        mPresenter.init();
    }
}