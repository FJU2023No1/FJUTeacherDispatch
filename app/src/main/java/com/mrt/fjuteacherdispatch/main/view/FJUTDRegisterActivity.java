package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjutdAppActivityRegisterBinding;
import com.mrt.fjuteacherdispatch.main.model.FJUTDRegisterModel;
import com.mrt.fjuteacherdispatch.main.presenter.FJUTDRegisterPresenter;

public class FJUTDRegisterActivity extends AppCompatActivity {

    private FjutdAppActivityRegisterBinding binding;

    private FJUTDRegisterPresenter mPresenter;

    private FJUTDRegisterModel mModel;

    public static void startActivity(
            Activity activity,
            boolean isFinish
    ) {
        Intent intent = new Intent(activity, FJUTDRegisterActivity.class);
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
        mModel = new FJUTDRegisterModel();
        mPresenter = new FJUTDRegisterPresenter(this, mModel);

        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        mPresenter.init();
    }
}