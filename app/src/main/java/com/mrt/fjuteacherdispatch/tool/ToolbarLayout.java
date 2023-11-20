package com.mrt.fjuteacherdispatch.tool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import com.google.android.material.appbar.AppBarLayout;
import com.mrt.fjuteacherdispatch.R;

public class ToolbarLayout extends AppBarLayout {

    private Context mContext;

    private View layout;

    private TextView titleView;

    private LinearLayout toolbarLayout;

    private AppCompatButton toolbarLeftBtn;

    private AppCompatImageButton toolbarLeftImageBtn;

    private AppCompatButton toolbarRightBtn;

    private AppCompatImageButton toolbarRightImageBtn;

    private RelativeLayout toolbarRightView;

    public ToolbarLayout(@NonNull Context context) {
        super(context);
    }

    public ToolbarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView(context, attrs);
    }

    public ToolbarLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(R.layout.fju_td_app_layout_toolbar, this);

        titleView = layout.findViewById(R.id.toolbarTitle);
        toolbarLayout = layout.findViewById(R.id.toolbarLayout);
        toolbarLeftBtn = layout.findViewById(R.id.toolbarLeftBtn);
        toolbarLeftImageBtn = layout.findViewById(R.id.toolbarLeftImageBtn);
        toolbarRightBtn = layout.findViewById(R.id.toolbarRightBtn);
        toolbarRightImageBtn = layout.findViewById(R.id.toolbarRightImageBtn);
        toolbarRightView = layout.findViewById(R.id.toolbarRightView);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setTitleColor(int color) {
        titleView.setTextColor(color);
    }

    public void setFocus(Boolean isFocus) {
        titleView.setFocusable(isFocus);
    }

    public void setBackgroundColor(int color) {
        toolbarLayout.setBackgroundColor(color);
    }

    /**
     * 是否顯示左邊按鈕(Button)元件.
     * @param isLeftBtnVisibility
     */
    public void setLeftBtnVisibility(Boolean isLeftBtnVisibility) {
        toolbarLeftBtn.setVisibility(isLeftBtnVisibility?View.VISIBLE:View.GONE);
    }

    /**
     * 設定左邊按鈕(Button)元件按下事件.
     * @param listener
     */
    public void setLeftBtnOnClick(OnClickListener listener) {
        toolbarLeftBtn.setOnClickListener(listener);
    }

    /**
     * 設定左邊按鈕(Button)元件顯示文字.
     * @param btnText
     */
    public void setLeftBtnText(String btnText) {
        toolbarLeftBtn.setText(btnText);
    }

    /**
     * 設定左邊按鈕(Button)元件顯示文字顏色.
     * @param color
     */
    public void setLeftBtnTextColor(int color) {
        toolbarLeftBtn.setTextColor(color);
    }

    /**
     * 設定左邊按鈕(Button)元件Padding.
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public void setLeftBtnPadding(int left, int top, int right, int bottom) {
        toolbarLeftBtn.setPadding(left, top, right, bottom);
    }

    /**
     * 是否顯示左邊圖片按鈕(ImageButton)元件.
     * @param isLeftImageVisibility
     */
    public void setLeftImageBtnVisibility(Boolean isLeftImageVisibility) {
        toolbarLeftImageBtn.setVisibility(isLeftImageVisibility?View.VISIBLE:View.GONE);
    }

    /**
     * 設定左邊圖片按鈕(ImageButton)元件按下事件.
     * @param listener
     */
    public void setLeftImageBtnOnClick(OnClickListener listener) {
        toolbarLeftImageBtn.setOnClickListener(listener);
    }

    /**
     * 設定左邊圖片按鈕(ImageButton)元件說明文字.
     * @param getLeftBtnContentDescription
     */
    public void setLeftImageBtnContentDescription(String getLeftBtnContentDescription) {
        toolbarLeftImageBtn.setContentDescription(getLeftBtnContentDescription);
    }

    /**
     * 設定左邊圖片按鈕(ImageButton)元件圖片.
     * @param resId
     */
    public void setLeftImageBtnResource(@DrawableRes int resId) {
        toolbarLeftImageBtn.setImageResource(resId);
    }

    /**
     * 設定左邊圖片按鈕(ImageButton)元件Padding.
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public void setLeftImageBtnPadding(int left, int top, int right, int bottom) {
        toolbarLeftImageBtn.setPadding(left, top, right, bottom);
    }

    /**
     * 是否顯示右邊按鈕元件.
     * @param isRightBtnVisibility
     */
    public void setRightBtnVisibility(Boolean isRightBtnVisibility) {
        toolbarRightBtn.setVisibility(isRightBtnVisibility?View.VISIBLE:View.GONE);
    }

    /**
     * 設定右邊按鈕元件按下事件.
     * @param listener
     */
    public void setRightBtnOnClick(OnClickListener listener) {
        toolbarRightBtn.setOnClickListener(listener);
    }

    /**
     * 設定右邊按鈕元件顯示文字.
     * @param btnText
     */
    public void setRightBtnText(String btnText) {
        toolbarRightBtn.setText(btnText);
    }

    /**
     * 設定右邊按鈕元件顯示文字顏色.
     * @param color
     */
    public void setRightBtnTextColor(int color) {
        toolbarRightBtn.setTextColor(color);
    }

    /**
     * 是否顯示右邊圖片按鈕元件.
     * @param isRightImageVisibility
     */
    public void setRightImageBtnVisibility(Boolean isRightImageVisibility) {
        toolbarRightImageBtn.setVisibility(isRightImageVisibility?View.VISIBLE:View.GONE);
    }

    /**
     * 設定右邊圖片按鈕元件按下事件.
     * @param listener
     */
    public void setRightImageBtnOnClick(OnClickListener listener) {
        toolbarRightImageBtn.setOnClickListener(listener);
    }

    /**
     * 設定右邊圖片按鈕元件說明文字.
     * @param getRightBtnContentDescription
     */
    public void setRightImageBtnContentDescription(String getRightBtnContentDescription) {
        toolbarRightImageBtn.setContentDescription(getRightBtnContentDescription);
    }

    /**
     * 設定右邊圖片按鈕元件圖片.
     * @param resId
     */
    public void setRightImageBtnResource(@DrawableRes int resId) {
        toolbarRightImageBtn.setImageResource(resId);
    }

    public void setRightView(View rightView) {
        toolbarRightView.addView(rightView);
    }

    public void setRightViewVisibility(Boolean isRightViewVisibility) {
        toolbarRightView.setVisibility(isRightViewVisibility?View.VISIBLE:View.GONE);
    }
}

