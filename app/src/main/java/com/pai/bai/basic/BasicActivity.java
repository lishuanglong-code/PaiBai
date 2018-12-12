package com.pai.bai.basic;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BasicActivity extends AppCompatActivity {

    public Lifecycle mLifecycle;
    public ViewDataBinding mViewDataBinding;
    private LifecycleObserver mLifecycleObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mLifecycle = this.getLifecycle();
        //绑定生命周期
        mLifecycleObserver = getLifecycleObserver();
        mLifecycle.addObserver(mLifecycleObserver);
    }

    public abstract int getLayoutId();

    public abstract LifecycleObserver getLifecycleObserver();

    /**
     * 删除生命周期观察者
     */
    public void removeObserver() {
        mLifecycle.removeObserver(mLifecycleObserver);
    }
}
