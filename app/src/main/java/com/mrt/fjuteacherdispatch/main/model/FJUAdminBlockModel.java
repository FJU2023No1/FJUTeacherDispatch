package com.mrt.fjuteacherdispatch.main.model;

import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class FJUAdminBlockModel {

    public FJUAdminBlockModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }
}
