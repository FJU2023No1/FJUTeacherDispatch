package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import me.majiajie.pagerbottomtabstrip.NavigationController;

public class MainTabbarModel {

    private NavigationController mNavigationController;

    public void setNavigationController(NavigationController mNavigationController) {
        this.mNavigationController = mNavigationController;
    }

    public NavigationController getNavigationController() {
        return mNavigationController;
    }

    public final ObservableField<String> userIdentityID = new ObservableField<>();
}
