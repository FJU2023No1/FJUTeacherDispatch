package com.mrt.fjuteacherdispatch.tool.menu.presenter;

import android.content.Context;

import com.mrt.fjuteacherdispatch.tool.menu.model.MenuAdapterModel;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuAdapterListener;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuItemListener;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

public class MenuAdapterPresenter<MenuItem extends MenuItemListener> {

    private final Context mContext;
    private final MenuAdapterModel mModel;
    private final MenuAdapterListener menuAdapterListener;
    private final MenuItem menuItem;
    private final MenuListener menuListener;

    public MenuAdapterPresenter(
            Context mContext,
            MenuAdapterModel mModel,
            MenuAdapterListener menuAdapterListener,
            MenuItem menuItem,
            MenuListener menuListener) {
        this.mContext = mContext;
        this.mModel = mModel;
        this.menuAdapterListener = menuAdapterListener;
        this.menuItem = menuItem;
        this.menuListener = menuListener;
    }

    public void init() {
        mModel.itemName.set(menuItem.getItemName());
    }

    public void onClickItem() {
        if (menuItem.getItemId() == -1) {
            menuListener.onCancel();
            menuAdapterListener.dismissAllowingStateLoss();
        } else {
            menuListener.onClickItem(menuItem);
            menuAdapterListener.dismissAllowingStateLoss();
        }
    }
}