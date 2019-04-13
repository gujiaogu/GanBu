package com.uestc.ganbu.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.util.SharedPreferenceUtil;

import butterknife.ButterKnife;

/**
 * Created by Tyrese on 2018/4/10.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected SharedPreferenceUtil preferences;
    protected Resources mRes;
    protected Context mCtx;
    protected ProgressDialog pd;
    protected MyApplication application = null;
    protected LocalBroadcastManager localBroadcastManager;

    public abstract int setContentViewId();
    public abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        ButterKnife.bind(this);
        preferences = new SharedPreferenceUtil(this);
        mRes = getResources();
        mCtx = this;
        application = (MyApplication) getApplication();
        localBroadcastManager = LocalBroadcastManager.getInstance(mCtx);
        initReceiver();
        registerBroadcast();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        unRegisterBroadcast();
        super.onDestroy();
    }

    protected void initReceiver() {
    }

    protected void registerBroadcast() {
    }

    protected void unRegisterBroadcast() {
    }

    protected void showProgress() {
        showProgress("加载中...");
    }

    protected void showProgress(String message) {
        if (isActivityAlive()) {
            pd = new ProgressDialog(this);
            pd.setMessage(message);
            pd.setCanceledOnTouchOutside(false);
            pd.show();
        }
    }

    protected void dismiss() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    protected boolean isActivityAlive() {
        return !isFinishing() && !isDestroyed();
    }
}
