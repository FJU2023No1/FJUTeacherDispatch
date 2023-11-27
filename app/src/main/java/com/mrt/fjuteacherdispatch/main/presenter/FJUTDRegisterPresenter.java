package com.mrt.fjuteacherdispatch.main.presenter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;

import com.mrt.fjuteacherdispatch.main.model.FJUTDRegisterModel;
import com.mrt.fjuteacherdispatch.main.model.data.CountryType;
import com.mrt.fjuteacherdispatch.main.model.data.GenderType;
import com.mrt.fjuteacherdispatch.main.view.FJUTDLoginWebActivity;
import com.mrt.fjuteacherdispatch.main.view.FJUTDRegisterActivity;
import com.mrt.fjuteacherdispatch.main.view.MainTabbarActivity;
import com.mrt.fjuteacherdispatch.main.view.factory.CountryItemFactory;
import com.mrt.fjuteacherdispatch.main.view.factory.GenderItemFactory;
import com.mrt.fjuteacherdispatch.main.view.verify.VerifyUserInfoPageField;
import com.mrt.fjuteacherdispatch.tool.DateTextWatcher;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;
import com.mrt.fjuteacherdispatch.tool.menu.view.fragment.MenuDialogFragment;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

import java.util.ArrayList;

public class FJUTDRegisterPresenter {

    private FJUTDRegisterActivity mActivity;

    private FJUTDRegisterModel mModel;

    private ArrayList<MenuItem> userInfoGenderItems;

    private ArrayList<MenuItem> userInfoCountryItems;

    private TextWatcher textWatcher422;

    public FJUTDRegisterPresenter(FJUTDRegisterActivity mActivity,
                                  FJUTDRegisterModel mModel) {
        this.mActivity = mActivity;
        this.mModel = mModel;
    }

    public void setBundle(Bundle bundle) {

        if (bundle != null) {
            if (bundle.getSerializable(FJUTDLoginWebActivity.FIELD_USER_TYPE_DATA) != null) {
                mModel.userIdentityID.set(String.valueOf(bundle.getSerializable(FJUTDLoginWebActivity.FIELD_USER_TYPE_DATA)));

                Log.e("TEST", mModel.userIdentityID.get().toString());
            }
        }
    }

    public void init() {
        mActivity.lockButtonDetermine();

        mModel.userInfoGenderText.set("請選擇您的性別");
        userInfoGenderItems = GenderItemFactory.createItem();
        for (int i = 0; i < userInfoGenderItems.size(); i++) {
            GenderType genderType = GenderType.getByteValueName(userInfoGenderItems.get(i).getItemName());
            mModel.userInfoGenderlist.add(new MenuItem(genderType.getMenuItem().getItemId(), userInfoGenderItems.get(i).getItemName()));
        }

        mModel.userInfoCountryText.set("請選擇您的國籍");
        userInfoCountryItems = CountryItemFactory.createItem();
        for (int i = 0; i < userInfoCountryItems.size(); i++) {
            CountryType countryType = CountryType.getByteValueName(userInfoCountryItems.get(i).getItemName());
            mModel.userInfoCountrylist.add(new MenuItem(countryType.getMenuItem().getItemId(), userInfoCountryItems.get(i).getItemName()));
        }

//        mModel.userInfoGenderText.set("請選擇您教授的科目");
//        identityItems = IdentityItemFactory.createItem();
//        for (int i = 0; i < identityItems.size(); i++) {
//            IdentityType identityType = IdentityType.getByteValueName(identityItems.get(i).getTypeName());
//            mModel.userInfoGenderlist.add(new MenuItem(identityType.getItem().getTypeID(), identityItems.get(i).getTypeName()));
//        }

//        mModel.userInfoGenderText.set("請選擇您會的語言");
//        identityItems = IdentityItemFactory.createItem();
//        for (int i = 0; i < identityItems.size(); i++) {
//            IdentityType identityType = IdentityType.getByteValueName(identityItems.get(i).getTypeName());
//            mModel.userInfoGenderlist.add(new MenuItem(identityType.getItem().getTypeID(), identityItems.get(i).getTypeName()));
//        }

        // 出生日期(海外)3-1.
        textWatcher422 = new DateTextWatcher(DateTextWatcher.TAG_DATE_TYPE_AD, mActivity.getUserBirthdateEdit(), null) {
            @Override
            public void afterTextChanged(Editable editable) {
                afterUserADBirthDateChanged(editable);
            }
        };

        mActivity.getUserBirthdateEdit().addTextChangedListener(textWatcher422);
    }

    public void afterUserNameChanged(Editable editable) {
        checkAllField(VerifyUserInfoPageField.UserName);

    }

    public void afterUserADBirthDateChanged(Editable editable) {
        checkAllField(VerifyUserInfoPageField.UserBirthDate);
    }

    public void onGenderSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.userInfoGenderText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.userInfoGenderlist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    public void onCountrySelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.userInfoCountryText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.userInfoCountrylist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    public void onSubjectSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.userInfoSubjectText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.userInfoSubjectlist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    public void onLanguageSelect() {
        MenuDialogFragment mMenuDialogFragment = new MenuDialogFragment(
                new MenuListener<MenuItem>() {
                    @Override
                    public void onClickItem(MenuItem menuItem) {
                        mModel.userInfoLanguageText.set(menuItem.getItemName());
                    }

                    @Override
                    public void onCancel() {
                        // Handle cancellation if needed
                    }
                },
                mModel.userInfoLanguagelist.toArray(new MenuItem[0])
        );

        mMenuDialogFragment.show(
                mActivity.getSupportFragmentManager(),
                MenuDialogFragment.FRAGMENT_TAG_NAME
        );
    }

    private void checkAllField(
            VerifyUserInfoPageField verifyUserInfoPageField
    ) {
        boolean checkUniformCountry = false;
        boolean checkUniformName = false;
        boolean checkUniformBirthDate = false;
        boolean checkUniformGender = false;

        if(!TextUtils.isEmpty(mModel.userInfoCountryText.get())) {
            checkUniformCountry = true;
        }

        if(!TextUtils.isEmpty(mModel.userInfoNameText.get())) {
            checkUniformName = true;
        }

        if(!TextUtils.isEmpty(mModel.userInfoGenderText.get())) {
            checkUniformGender = true;
        }

        if(!TextUtils.isEmpty(mModel.userInfoBirthDateText.get())) {
            checkUniformBirthDate = true;
        }

        if(checkUniformCountry &&
                checkUniformName &&
                checkUniformBirthDate &&
                checkUniformGender) {
            mActivity.unlockButtonDetermine();
        } else {
            mActivity.lockButtonDetermine();
        }

        if (verifyUserInfoPageField == VerifyUserInfoPageField.Unknown) {
            mModel.getClickLock().unlock();
        }
    }

    public void onDetermine() {
        MainTabbarActivity.startActivity(mActivity, true);
    }
}
