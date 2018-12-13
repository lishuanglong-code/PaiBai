package com.pai.bai.util;

public class TestUtil {

    static {
        System.loadLibrary("native-lib");
    }

    public native static String stringFromJNI();
}
