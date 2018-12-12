package com.pai.bai.basic;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ViewDataBinding;


public abstract class BasicLifecycleObserver implements LifecycleObserver {

    private BasicActivity activity;
    private ViewDataBinding binding;
    private Lifecycle lifecycle;

    public BasicLifecycleObserver(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {
        this.activity = activity;
        this.binding = binding;
        this.lifecycle = lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        create(activity, binding, lifecycle);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        start(activity, binding, lifecycle);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        resume(activity, binding, lifecycle);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        pause(activity, binding, lifecycle);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        stop(activity, binding, lifecycle);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        destroy(activity, binding, lifecycle);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        any(activity, binding, lifecycle);
    }

    public abstract void create(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);

    public abstract void start(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);

    public abstract void resume(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);

    public abstract void pause(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);

    public abstract void stop(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);

    public abstract void destroy(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);

    public abstract void any(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle);
}
