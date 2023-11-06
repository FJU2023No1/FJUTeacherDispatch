package com.mrt.fjuteacherdispatch.main.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.main.model.FJUTDModel;
import com.mrt.fjuteacherdispatch.main.model.data.ListUserIdentity;
import com.mrt.fjuteacherdispatch.main.view.FJUTDActivity;
import com.mrt.fjuteacherdispatch.main.view.FJUTDRegisterActivity;
import com.mrt.fjuteacherdispatch.tool.SpinnerActivity;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class FJUTDPresenter {

    private FJUTDActivity mActivity;

    private FJUTDModel mModel;

    private ListUserIdentity userIdentities[];

    private ActivityResultLauncher<Intent> activityUserIdentityResultLauncher;

    public FJUTDPresenter (FJUTDActivity mActivity,
                           FJUTDModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;

        userIdentityForActivityResult();
    }

    public void init() {
        mModel.userIdentityText.set("請選擇您的身份");
        initSpinner();
        mActivity.getUserIdentitySpinner().setOnClickListener(mIdentityClickListener);
    }

    public void userIdentityForActivityResult() {
        activityUserIdentityResultLauncher = mActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK) {
                    if (result.getData()!=null) {
                        Map.Entry<String,String> entry = (Map.Entry<String,String>) result.getData().getSerializableExtra(SpinnerActivity.Result_Data);
                        if (entry != null) {
                            mModel.userIdentityText.set(entry.getValue());
                        }
                    }
                } else {

                }
            }
        });
    }

    private View.OnClickListener mIdentityClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SpinnerActivity.startActivityForResultLauncher(mActivity, activityUserIdentityResultLauncher, mModel.getUserIdentityArray());
        }
    };

    public void initSpinner() {
        ArrayList<Map.Entry<String, String>> userIdentityArray = new ArrayList<Map.Entry<String, String>>();
        String[] listUserIdentity = mActivity.getResources().getStringArray(R.array.fjutd_app_user_identity_array);
        for (String userIdentity: listUserIdentity) {
            String[] split = userIdentity.split(",");
            userIdentityArray.add(new AbstractMap.SimpleEntry<>(split[1], split[0]));
        }
        mModel.setUserIdentityArray(userIdentityArray);
    }

    public void onGoToLogin() {
        Toast.makeText(mActivity, "前往登入頁", Toast.LENGTH_LONG).show();
    }

    public void onGoToRegister() {
        FJUTDRegisterActivity.startActivity(mActivity, false);
    }

//    public void onGoToAdministrator() {
//        Toast.makeText(mActivity, "Admin", Toast.LENGTH_LONG).show();
//    }
}
