package com.pai.bai;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * 此类的变量均为单例模式
 */
public class BasicApp extends Application {

    public static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {

        super.onLowMemory();
    }

    /**
     * 程序在内存清理的时候执行（回收内存）
     * HOME键退出应用程序、长按MENU键，打开Recent TASK都会执行
     */
    @Override
    public void onTrimMemory(int level) {

        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
