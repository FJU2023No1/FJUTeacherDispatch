package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjutdAppActivitySettingBinding;
import com.mrt.fjuteacherdispatch.main.model.SettingModel;
import com.mrt.fjuteacherdispatch.main.presenter.SettingPresenter;

public class SettingActivity extends AppCompatActivity {

    private FjutdAppActivitySettingBinding binding;

    private SettingPresenter mPresenter;

    private SettingModel mModel;

    public static final String FIELD_USER_EMAIL_DATA = "fieldUserEMailData";

    public static void startActivity(
            Activity activity,
            String userMail
    ) {
        Intent intent = new Intent(activity, SettingActivity.class);
        intent.putExtra(FIELD_USER_EMAIL_DATA, userMail);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.fjutd_app_activity_setting
        );
        mModel = new SettingModel();
        mPresenter = new SettingPresenter(this, mModel);

        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        mPresenter.setBundle(getIntent().getExtras());
        mPresenter.init();
    }
}