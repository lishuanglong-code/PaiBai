package com.pai.bai.lifecycle;


import android.Manifest;
import android.arch.lifecycle.Lifecycle;
import android.databinding.ViewDataBinding;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.pai.bai.R;
import com.pai.bai.basic.BasicActivity;
import com.pai.bai.basic.BasicLifecycleObserver;
import com.pai.bai.fragment.Camera2BasicFragment;
import com.pai.bai.util.UIUtil;


public class MainLifecycleObserver extends BasicLifecycleObserver {

    public MainLifecycleObserver(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {
        super(activity, binding, lifecycle);
    }

    @Override
    public void create(final BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {
        //设置全屏
        ScreenUtils.setFullScreen(activity);
        //请求权限
        if (!PermissionUtils.isGranted(Manifest.permission.CAMERA)) {
            PermissionUtils.permission(Manifest.permission.CAMERA)
                    .callback(new PermissionUtils.SimpleCallback() {
                        @Override
                        public void onGranted() {
                            activity.getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fl_preview_context, new Camera2BasicFragment()).commit();
                        }

                        @Override
                        public void onDenied() {
                            ToastUtils.showLong(UIUtil.getString(R.string.permission_denied_hint));
                        }
                    }).request();

        } else {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_preview_context, new Camera2BasicFragment()).commit();
        }
    }

    @Override
    public void start(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {

    }

    @Override
    public void resume(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {

    }

    @Override
    public void pause(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {

    }

    @Override
    public void stop(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {

    }

    @Override
    public void destroy(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {

    }

    @Override
    public void any(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {

    }
}
