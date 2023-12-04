package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.mrt.fjuteacherdispatch.main.model.TeacherAddScheduleModel;
import com.mrt.fjuteacherdispatch.main.model.data.ClassLocationType;
import com.mrt.fjuteacherdispatch.main.model.data.ClassSubjectType;
import com.mrt.fjuteacherdispatch.main.model.data.ClassTimeType;
import com.mrt.fjuteacherdispatch.main.view.TeacherAddScheduleActivity;
import com.mrt.fjuteacherdispatch.main.view.factory.ClassLocationItemFactory;
import com.mrt.fjuteacherdispatch.main.view.factory.ClassSubjectItemFactory;
import com.mrt.fjuteacherdispatch.main.view.factory.ClassTimeItemFactory;
import com.mrt.fjuteacherdispatch.tool.DateTextWatcher;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;
import com.mrt.fjuteacherdispatch.tool.menu.view.fragment.MenuDialogFragment;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TeacherAddSchedulePresenter {

    private TeacherAddScheduleActivity mActivity;

    private TeacherAddScheduleModel mModel;

    private ArrayList<MenuItem> classTimeItems, classLocationItems,classSubjectItems;

    private TextWatcher textWatcher422;

    public TeacherAddSchedulePresenter (
            TeacherAddScheduleActivity mActivity,
            TeacherAddScheduleModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void setBundle(Bundle bundle) {

        if (bundle != null) {
            if (bundle.getSerializable(TeacherAddScheduleActivity.FIELD_USER_EMAIL_DATA) != null) {
                mModel.userMail.set(String.valueOf(bundle.getSerializable(TeacherAddScheduleActivity.FIELD_USER_EMAIL_DATA)));
            }
        }
    }

    public void init() {
        mModel.classTimeText.set("請選擇欲登錄上課時段");
        classTimeItems = ClassTimeItemFactory.createItem();
        for (int i = 0; i < classTimeItems.size(); i++) {
            ClassTimeType classTimeType = ClassTimeType.getByteValueName(classTimeItems.get(i).getItemName());
            mModel.classTimelist.add(new MenuItem(classTimeType.getMenuItem().getItemId(), classTimeItems.get(i).getItemName()));
        }

        mModel.classLocationText.set("請選擇希望上課地點");
        classLocationItems = ClassLocationItemFactory.createItem();
        for (int i = 0; i < classLocationItems.size(); i++) {
            ClassLocationType classLocationType = ClassLocationType.getByteValueName(classLocationItems.get(i).getItemName());
            mModel.classLocationlist.add(new MenuItem(classLocationType.getMenuItem().getItemId(), classLocationItems.get(i).getItemName()));
        }

        mModel.classSubjectText.set("請選擇要教授的科目");
        classSubjectItems = ClassSubjectItemFactory.createItem();
        for (int i = 0; i < classSubjectItems.size(); i++) {
            ClassSubjectType classSubjectType = ClassSubjectType.getByteValueName(classSubjectItems.get(i).getItemName());
            mModel.classSubjectlist.add(new MenuItem(classSubjectType.getMenuItem().getItemId(), classSubjectItems.get(i).getItemName()));
        }

        // 出生日期(海外)3-1.
        textWatcher422 = new DateTextWatcher(DateTextWatcher.TAG_DATE_TYPE_AD, mActivity.getClassDateEdit(), null) {
            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        mActivity.getClassDateEdit().addTextChangedListener(textWatcher422);
    }

    public void onDetermine() {
        sendRequestWithOkHttpForAddClassInfo();
        mActivity.finish();
    }

    public void onClassTimeSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.classTimeText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.classTimelist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    public void onClassLocationSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.classLocationText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.classLocationlist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    public void onClassSubjectSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.classSubjectText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.classSubjectlist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    private void sendRequestWithOkHttpForAddClassInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    //POST
                    RequestBody requestBody = new FormBody.Builder()
                            .add("TSTeacherEmail", mModel.userMail.get().toString())
                            .add("TSClassTime", mModel.classDateText.get().toString() + " " + mModel.classTimeText.get().toString())
                            .add("TSClassLocation", mModel.classLocationText.get().toString())
                            .add("TSMoney", mModel.classMoneyText.get().toString())
                            .add("TSSubject", mModel.classSubjectText.get().toString())
                            .build();
                    Request request = new Request.Builder()
                            .url("https://lynnxick.synology.me/api/FJU/AddTeacherSchedule.php")
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
