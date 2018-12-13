package com.pai.bai.lifecycle;


import android.Manifest;
import android.arch.lifecycle.Lifecycle;
import android.databinding.ViewDataBinding;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.pai.bai.BasicApp;
import com.pai.bai.R;
import com.pai.bai.basic.BasicActivity;
import com.pai.bai.basic.BasicLifecycleObserver;
import com.pai.bai.databinding.ActivityMainBinding;
import com.pai.bai.fragment.Camera2BasicFragment;
import com.pai.bai.util.TestUtil;
import com.pai.bai.util.TestUtils;
import com.pai.bai.util.UIUtil;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;


public class MainLifecycleObserver extends BasicLifecycleObserver {

    private BasicActivity activity;
    private ActivityMainBinding binding;
    private Lifecycle lifecycle;

    public MainLifecycleObserver(BasicActivity activity, ViewDataBinding binding, Lifecycle lifecycle) {
        super(activity, binding, lifecycle);
        this.activity = activity;
        this.binding = (ActivityMainBinding) binding;
        this.lifecycle = lifecycle;
    }

    @Override
    public void create() {
        //设置全屏
        ScreenUtils.setFullScreen(activity);

        binding.tvTest.setText(TestUtils.stringff());
//        //初始化 open cv
//        if (!OpenCVLoader.initDebug()) {
//            ToastUtils.showLong("OpenCV library not found!");
//        } else {
//            ToastUtils.showLong("OpenCV library found inside package. Using it!");
//            mBaseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
//        }
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void any() {

    }

    private BaseLoaderCallback mBaseLoaderCallback = new BaseLoaderCallback(BasicApp.context) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
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
                    break;
                default:
                    super.onManagerConnected(status);
                    break;
            }
        }
    };
}
