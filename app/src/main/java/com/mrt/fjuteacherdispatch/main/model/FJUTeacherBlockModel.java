package com.mrt.fjuteacherdispatch.main.model;

import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class FJUTeacherBlockModel {

    public FJUTeacherBlockModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }
}
