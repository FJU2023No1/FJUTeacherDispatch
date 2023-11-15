package com.mrt.fjuteacherdispatch.tool;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;

public class SystemSettingsUtil {

    /**
     * 預設系統字型大小.
     */
    private static final float SETTINGS_SYSTEM_FONT_SCALE = 1f;

    private SystemSettingsUtil() {

    }

    /**
     * 取得系統目前設定字型大小.
     *
     * @param ctx
     * @return
     */
    public static float getFontScale(Context ctx) {
        ContentResolver resolver = ctx.getContentResolver();
        String value = Settings.System.getString(resolver, Settings.System.FONT_SCALE);
        if (value != null) {
            return DataFormatUtil.isFloat(value) ? Float.parseFloat(value) : SETTINGS_SYSTEM_FONT_SCALE;
        } else {
            return SETTINGS_SYSTEM_FONT_SCALE;
        }
    }

    public static int systemScreenBrightnessMode(Context context) {
        int mode = -1;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            mode = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE);
        } catch (Exception e) {
            Log.e("exceptionLog", e.getMessage());
        }
        return mode;
    }
}
