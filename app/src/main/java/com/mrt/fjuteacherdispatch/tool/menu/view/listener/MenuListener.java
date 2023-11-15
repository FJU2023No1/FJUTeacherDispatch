package com.mrt.fjuteacherdispatch.tool.menu.view.listener;

public interface MenuListener<MenuItem extends MenuItemListener> {

    void onClickItem(MenuItem menuItem);

    void onCancel();
}
