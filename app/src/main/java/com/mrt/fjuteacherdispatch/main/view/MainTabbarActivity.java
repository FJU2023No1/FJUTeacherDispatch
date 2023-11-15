package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppActivityMainTabbarBinding;
import com.mrt.fjuteacherdispatch.main.model.MainTabbarModel;
import com.mrt.fjuteacherdispatch.main.presenter.MainTabbarPresenter;
import com.mrt.fjuteacherdispatch.main.view.listener.MainTabbarListener;

public class MainTabbarActivity extends AppCompatActivity implements MainTabbarListener {

    private FjuTdAppActivityMainTabbarBinding binding;

    private MainTabbarPresenter mPresenter;

    private MainTabbarModel mModel;

    public static void startActivity(
            Activity activity,
            boolean isFinish) {
        Intent intent = createIntent(activity);
        activity.startActivity(intent);

        if (isFinish) {
            activity.finish();
        }
    }

    public static void startActivityForResultLauncher(
            Context context,
            ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = createIntent(context);
        activityResultLauncher.launch(intent);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MainTabbarActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.fju_td_app_activity_main_tabbar
        );
        mModel = new MainTabbarModel();
        mPresenter = new MainTabbarPresenter(this, mModel, this);

        mPresenter.init();
    }
}