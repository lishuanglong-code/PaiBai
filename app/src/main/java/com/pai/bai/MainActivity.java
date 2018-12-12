package com.pai.bai;


import android.arch.lifecycle.LifecycleObserver;

import com.pai.bai.basic.BasicActivity;
import com.pai.bai.lifecycle.MainLifecycleObserver;

/**
 * MainActivity
 */
public class MainActivity extends BasicActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public LifecycleObserver getLifecycleObserver() {
        return new MainLifecycleObserver(this, mViewDataBinding, mLifecycle);
    }
}
