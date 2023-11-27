package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

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

    public static final String FIELD_USER_TYPE_DATA = "fieldUserTypeData";

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

    public static void startActivity(
            Context context
    ) {
        Intent intent = new Intent(context, FJUTDRegisterActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(
            Context context,
            int userType
    ) {
        Intent intent = new Intent(context, FJUTDRegisterActivity.class);
        intent.putExtra(FIELD_USER_TYPE_DATA, userType);
        context.startActivity(intent);
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

        mPresenter.setBundle(getIntent().getExtras());
        mPresenter.init();
    }

    /**
     * 鎖住確定按鈕.
     */
    public void lockButtonDetermine() {
        binding.determine
                .setEnabled(false);
    }

    /**
     * 解鎖確定按鈕.
     */
    public void unlockButtonDetermine() {
        binding.determine
                .setEnabled(true);
    }

    /**
     * 出生日期.
     * @return
     */
    public EditText getUserBirthdateEdit() {
        return binding.userBirthdateEdit;
    }
}