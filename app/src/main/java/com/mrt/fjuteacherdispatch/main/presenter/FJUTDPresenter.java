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
import com.mrt.fjuteacherdispatch.main.view.MainTabbarActivity;
import com.mrt.fjuteacherdispatch.main.view.factory.IdentityItemFactory;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;
import com.mrt.fjuteacherdispatch.tool.menu.view.fragment.MenuDialogFragment;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

import java.util.ArrayList;

public class FJUTDPresenter {

    private FJUTDActivity mActivity;

    private FJUTDModel mModel;

    private ListUserIdentity userIdentities[];

    private ArrayList<IdentityItem> identityItems;

    public FJUTDPresenter (FJUTDActivity mActivity,
                           FJUTDModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void init() {
        userIdentityForActivityResult();

        mModel.userIdentityText.set("請選擇您的身份");

        identityItems = IdentityItemFactory.createItem();
        for (int i = 0; i < identityItems.size(); i++) {
            IdentityType identityType = IdentityType.getByteValueName(identityItems.get(i).getTypeName());
            mModel.list.add(new MenuItem(identityType.getItem().getTypeID(), identityItems.get(i).getTypeName()));
        }
    }

    public void userIdentityForActivityResult() {
    }

    public void onGoToLogin() {
        if (mModel.userIdentityText.get().equals("學生")) {
            FJUTDRegisterActivity.startActivity(mActivity, false);
        } else {
            MainTabbarActivity.startActivity(mActivity, true);
        }
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
