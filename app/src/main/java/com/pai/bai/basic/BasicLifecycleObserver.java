package com.pai.bai.basic;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ViewDataBinding;


public abstract class BasicLifecycleObserver implements LifecycleObserver {

    public BasicLifecycleObserver(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        create();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        resume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        destroy();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        any();
    }

    public abstract void create();

    public abstract void start();

    public abstract void resume();

    public abstract void pause();

    public abstract void stop();

    public abstract void destroy();

    public abstract void any();
}
