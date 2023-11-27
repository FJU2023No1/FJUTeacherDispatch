package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class HomePageModel {

    private ClickLock clickLock;

    public HomePageModel() {
        clickLock = new ClickLock();
    }

    public ClickLock getClickLock() {
        return clickLock;
    }

    public final ObservableField<String> userIdentityID = new ObservableField<>();
}
