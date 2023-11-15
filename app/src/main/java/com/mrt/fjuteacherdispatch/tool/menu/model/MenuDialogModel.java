package com.mrt.fjuteacherdispatch.tool.menu.model;

import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class MenuDialogModel {

    public MenuDialogModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }
}
