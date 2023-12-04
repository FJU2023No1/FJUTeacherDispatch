package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjutdAppActivityTeacherAddScheduleBinding;
import com.mrt.fjuteacherdispatch.main.model.TeacherAddScheduleModel;
import com.mrt.fjuteacherdispatch.main.presenter.TeacherAddSchedulePresenter;

public class TeacherAddScheduleActivity extends AppCompatActivity {

    private FjutdAppActivityTeacherAddScheduleBinding binding;

    private TeacherAddSchedulePresenter mPresenter;

    private TeacherAddScheduleModel mModel;

    public static final String FIELD_USER_EMAIL_DATA = "fieldUserEMailData";

    public static void startActivity(
            Activity activity,
            boolean isFinish
    ) {
        Intent intent = new Intent(activity, TeacherAddScheduleActivity.class);
        activity.startActivity(intent);
        if (isFinish) {
            activity.finish();
        }
    }

    public static void startActivity(
            Activity activity,
            String email
    ) {
        Intent intent = new Intent(activity, TeacherAddScheduleActivity.class);
        intent.putExtra(FIELD_USER_EMAIL_DATA, email);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.fjutd_app_activity_teacher_add_schedule
        );
        mModel = new TeacherAddScheduleModel();
        mPresenter = new TeacherAddSchedulePresenter(this, mModel);

        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        mPresenter.setBundle(getIntent().getExtras());
        mPresenter.init();
    }
}