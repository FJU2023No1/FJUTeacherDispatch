package com.mrt.fjuteacherdispatch.tool;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.WindowManager;

public class DeviceDisplayUtil {

    public static final int BRIGHTNESS_FULL = 255;

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static float getStatusBarHeightInDp(Context ctx) {
        return 25f;
    }

    public static float getAppBarHeightInDp(Context ctx) {
        TypedValue tv = new TypedValue();
        if (ctx.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data, ctx.getResources().getDisplayMetrics()) / ctx.getResources().getDisplayMetrics().density;
        } else {
            return 56f;
        }
    }

    public static int getStatusBarHeightCompat(Context ctx) {
        int result = 0;
        int resId = ctx.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            result = ctx.getResources().getDimensionPixelOffset(resId);
        }
        if (result <= 0) {
            result = dp2px(ctx, 25f);
        }
        return result;
    }

    public static boolean setBrightness(Activity activity, int brightness) {
        if (activity == null) {
            return false;
        }
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        if (brightness == -1) {
            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
        } else {
            lp.screenBrightness = brightness / 255f;
        }
        activity.getWindow().setAttributes(lp);
        return true;
    }

    public static int getScreenBrightness(Activity activity) {
        if (activity == null) {
            return 0;
        }
        int defVal = 125;
        try {
            Settings.System.getInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return defVal;
    }

    public static boolean isAutoBrightness(Activity activity) {
        if (activity == null) {
            return false;
        }
        return SystemSettingsUtil.systemScreenBrightnessMode(activity) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
    }

    public static boolean setKeepOnScreen(Activity activity, boolean isKeepOnScreen) {
        if (activity == null) {
            return false;
        }
        if (isKeepOnScreen) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
        return true;
    }
}
