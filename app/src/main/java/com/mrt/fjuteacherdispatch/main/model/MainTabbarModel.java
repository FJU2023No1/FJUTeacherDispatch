package com.mrt.fjuteacherdispatch.main.model;

import me.majiajie.pagerbottomtabstrip.NavigationController;

public class MainTabbarModel {

    private NavigationController mNavigationController;

    public void setNavigationController(NavigationController mNavigationController) {
        this.mNavigationController = mNavigationController;
    }

    public NavigationController getNavigationController() {
        return mNavigationController;
    }
}
