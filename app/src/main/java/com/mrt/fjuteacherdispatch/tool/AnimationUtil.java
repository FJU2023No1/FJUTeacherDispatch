package com.mrt.fjuteacherdispatch.tool;

import android.app.Activity;

public class AnimationUtil {

    private AnimationUtil() {

    }

    /**
     * 關閉 Activity 進場或離場的動畫效果.
     * @param activity
     */
    public static void closeActivityAnim(Activity activity) {
        activity.overridePendingTransition(0, 0);
    }
}