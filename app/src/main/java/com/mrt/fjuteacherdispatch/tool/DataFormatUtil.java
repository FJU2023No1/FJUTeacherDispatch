package com.mrt.fjuteacherdispatch.tool;

import java.math.BigDecimal;

public class DataFormatUtil {

    private DataFormatUtil() {

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String s) {
        if(s == null) {
            return false;
        }

        try {
            Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        if(s == null) {
            return false;
        }

        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isBigDecimal(String s) {
        if(s == null) {
            return false;
        }

        try {
            new BigDecimal(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * 格式化Array轉字串並加上指定分隔字串.
     * @return
     */
    public static <E extends TypeString> String formatArrayString(E[] array, String delimiter) {
        StringBuilder builder = new StringBuilder(0);
        for(int i=0; i< array.length; i++) {
            builder.append(array[i].getType());
            if(i + 1 < array.length) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }
}
