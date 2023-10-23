package com.mrt.fjuteacherdispatch.main.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjutdAppActivityLaunchBinding;
import com.mrt.fjuteacherdispatch.main.model.FJUTDModel;
import com.mrt.fjuteacherdispatch.main.presenter.FJUTDPresenter;

public class FJUTDActivity extends AppCompatActivity {

    private FjutdAppActivityLaunchBinding binding;

    private FJUTDPresenter mPresenter;

    private FJUTDModel mModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.fjutd_app_activity_launch
        );
        mModel = new FJUTDModel();
        mPresenter = new FJUTDPresenter(this, mModel);

        mPresenter.init();
    }
}
