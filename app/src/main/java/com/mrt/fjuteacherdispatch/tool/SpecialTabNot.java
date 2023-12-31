package com.mrt.fjuteacherdispatch.tool;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.mrt.fjuteacherdispatch.R;

import me.majiajie.pagerbottomtabstrip.internal.RoundMessageView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;

public class SpecialTabNot extends BaseTabItem {

    private RelativeLayout mTab;
    private ImageView mIcon;
    private final TextView mTitle;
    private final RoundMessageView mMessages;

    private Drawable mDefaultDrawable;
    private Drawable mCheckedDrawable;

    private int mDefaultTextColor = 0x56000000;
    private int mCheckedTextColor = 0x56000000;

    private boolean mChecked;

    public SpecialTabNot(Context context) {
        this(context, null);
    }

    public SpecialTabNot(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpecialTabNot(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.fju_td_app_layout_special_tab_not, this, true);

        mTab = findViewById(R.id.tab);
        mIcon = findViewById(R.id.icon);
        mTitle = findViewById(R.id.title);
        mMessages = findViewById(R.id.messages);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        View view = getChildAt(0);
        if (view != null) {
            view.setOnClickListener(l);
        }
    }

    /**
     * 方便初始化的方法.
     *
     * @param drawableRes        預設狀態的圖標
     * @param checkedDrawableRes 選取狀態的圖標
     * @param title              標題
     */
    public void initialize(@DrawableRes int drawableRes, @DrawableRes int checkedDrawableRes, String title) {
        mDefaultDrawable = ContextCompat.getDrawable(getContext(), drawableRes);
        mCheckedDrawable = ContextCompat.getDrawable(getContext(), checkedDrawableRes);
        mTitle.setText(title);
    }

    @Override
    public void setChecked(boolean checked) {
        if (checked) {
            mIcon.setImageDrawable(mCheckedDrawable);
            mTitle.setTextColor(mCheckedTextColor);
        } else {
            mIcon.setImageDrawable(mDefaultDrawable);
            mTitle.setTextColor(mDefaultTextColor);
        }
        mChecked = checked;
    }

    @Override
    public void setMessageNumber(int number) {
        mMessages.setMessageNumber(number);
    }

    @Override
    public void setHasMessage(boolean hasMessage) {
        mMessages.setHasMessage(hasMessage);
    }

    @Override
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void setDefaultDrawable(Drawable drawable) {
        mDefaultDrawable = drawable;
        if (!mChecked) {
            mIcon.setImageDrawable(drawable);
        }
    }

    @Override
    public void setSelectedDrawable(Drawable drawable) {
        mCheckedDrawable = drawable;
        if (mChecked) {
            mIcon.setImageDrawable(drawable);
        }
    }

    @Override
    public String getTitle() {
        return mTitle.getText().toString();
    }

    public void setTextDefaultColor(@ColorInt int color) {
        mDefaultTextColor = color;
    }

    public void setTextCheckedColor(@ColorInt int color) {
        mCheckedTextColor = color;
    }

    public void setTabBackground(Drawable drawable) {
        mTab.setBackground(drawable);
    }
}

