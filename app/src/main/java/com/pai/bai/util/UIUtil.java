package com.pai.bai.util;

import android.content.res.Resources;

import com.pai.bai.BasicApp;

public class UIUtil {

    public static Resources getResources() {
        return BasicApp.context.getResources();
    }

    public static String getString(int id) {
        return getResources().getString(id);
    }


}
