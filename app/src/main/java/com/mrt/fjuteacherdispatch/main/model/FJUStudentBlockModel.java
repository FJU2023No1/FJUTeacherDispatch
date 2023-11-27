package com.mrt.fjuteacherdispatch.main.model;

import com.mrt.fjuteacherdispatch.tool.ClickLock;

public class FJUStudentBlockModel {

    public FJUStudentBlockModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }
}
