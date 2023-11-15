package com.mrt.fjuteacherdispatch.tool.menu.model.data;

import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuItemListener;

public class MenuItem implements MenuItemListener {

    private int itemId;

    private String itemName;

    public MenuItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    @Override
    public int getItemId() {
        return itemId;
    }

    @Override
    public String getItemName() {
        return itemName;
    }
}
