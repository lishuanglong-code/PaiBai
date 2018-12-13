package com.pai.bai.util;

public class TestUtils {

    static {
        System.loadLibrary("add-lib");
    }

    public native static String stringff();
}
