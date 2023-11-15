package com.mrt.fjuteacherdispatch.tool;

public class ClickLock {

    /**
     * 這裡設置不能超過多長時間.
     */
    public static final int MIN_CLICK_DELAY_TIME = 1500;

    private boolean lock;

    private long lastClickTime;

    public ClickLock() {
        unlock();
    }

    public void lock() {
        lock = true;
    }

    public void unlock() {
        lock = false;
    }

    public boolean isLock() {
        return lock;
    }

    public boolean isNoLock() {
        return !lock;
    }

    public boolean isTimeLock() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public boolean isDoubleClick() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            return true;
        } else {
            return false;
        }
    }
}

