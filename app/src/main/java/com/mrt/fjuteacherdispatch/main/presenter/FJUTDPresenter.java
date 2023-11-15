package com.mrt.fjuteacherdispatch.main.presenter;

import android.content.Intent;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;

import com.mrt.fjuteacherdispatch.main.model.FJUTDModel;
import com.mrt.fjuteacherdispatch.main.model.data.IdentityType;
import com.mrt.fjuteacherdispatch.main.model.data.ListUserIdentity;
import com.mrt.fjuteacherdispatch.main.model.data.IdentityItem;
import com.mrt.fjuteacherdispatch.main.view.FJUTDActivity;
import com.mrt.fjuteacherdispatch.main.view.FJUTDRegisterActivity;
import com.mrt.fjuteacherdispatch.main.view.factory.IdentityItemFactory;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;
import com.mrt.fjuteacherdispatch.tool.menu.view.fragment.MenuDialogFragment;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

import java.util.ArrayList;

public class FJUTDPresenter {

    private FJUTDActivity mActivity;

    private FJUTDModel mModel;

    private ListUserIdentity userIdentities[];

    private ActivityResultLauncher<Intent> activityUserIdentityResultLauncher;

    private ArrayList<IdentityItem> identityItems;

    public FJUTDPresenter (FJUTDActivity mActivity,
                           FJUTDModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void init() {
        userIdentityForActivityResult();

        mModel.userIdentityText.set("請選擇您的身份");
//        initSpinner();
//        mActivity.getUserIdentitySpinner().setOnClickListener(mIdentityClickListener);

        identityItems = IdentityItemFactory.createItem();
        for (int i = 0; i < identityItems.size(); i++) {
            IdentityType identityType = IdentityType.getByteValueName(identityItems.get(i).getTypeName());
            mModel.list.add(new MenuItem(identityType.getItem().getTypeID(), identityItems.get(i).getTypeName()));
        }
    }

    public void userIdentityForActivityResult() {
//        activityUserIdentityResultLauncher = mActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//            @Override
//            public void onActivityResult(ActivityResult result) {
//                if(result.getResultCode() == Activity.RESULT_OK) {
//                    if (result.getData()!=null) {
//                        Map.Entry<String,String> entry = (Map.Entry<String,String>) result.getData().getSerializableExtra(SpinnerActivity.Result_Data);
//                        if (entry != null) {
//                            mModel.userIdentityText.set(entry.getValue());
//                        }
//                    }
//                } else {
//
//                }
//            }
//        });
    }

//    private View.OnClickListener mIdentityClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            SpinnerActivity.startActivityForResultLauncher(mActivity, activityUserIdentityResultLauncher, mModel.getUserIdentityArray());
//        }
//    };

//    public void initSpinner() {
//        ArrayList<Map.Entry<String, String>> userIdentityArray = new ArrayList<Map.Entry<String, String>>();
//        String[] listUserIdentity = mActivity.getResources().getStringArray(R.array.fjutd_app_user_identity_array);
//        for (String userIdentity: listUserIdentity) {
//            String[] split = userIdentity.split(",");
//            userIdentityArray.add(new AbstractMap.SimpleEntry<>(split[1], split[0]));
//        }
//        mModel.setUserIdentityArray(userIdentityArray);
//    }

    public void onGoToLogin() {
        Toast.makeText(mActivity, "前往登入頁", Toast.LENGTH_LONG).show();
    }

    public void onGoToRegister() {
        FJUTDRegisterActivity.startActivity(mActivity, false);
    }

    public void onTypeSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.userIdentityText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.list.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }
}
