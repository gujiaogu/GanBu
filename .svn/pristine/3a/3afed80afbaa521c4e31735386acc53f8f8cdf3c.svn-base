package com.uestc.ganbu.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.util.SharedPreferenceUtil;

import butterknife.ButterKnife;

/**
 * Created by Tyrese on 2018/4/12.
 */

public abstract class BaseFragment extends Fragment {

    protected Resources mRes;
    protected Activity mCtx;
    protected SharedPreferenceUtil preferences;
    protected ProgressDialog pd;
    protected MyApplication application = null;
    protected LocalBroadcastManager localBroadcastManager;

    public abstract int setContentView();
    public abstract void initView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRes = getResources();
        mCtx = getActivity();
        preferences = new SharedPreferenceUtil(mCtx);
        application = (MyApplication) mCtx.getApplication();
        localBroadcastManager = LocalBroadcastManager.getInstance(mCtx);

        initReceiver();
        registerBroadcast();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setContentView(), container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        unRegisterBroadcast();
        super.onDestroy();
    }

    protected void registerBroadcast() {
    }

    protected void unRegisterBroadcast() {
    }

    protected boolean isFragmentAlive() {
        return getActivity() != null && !isDetached();
    }

    protected void initReceiver() {
    }

    protected void showProgress() {
        showProgress("加载中...");
    }

    protected void showProgress(String message) {
        if (isFragmentAlive()) {
            pd = new ProgressDialog(mCtx);
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
}
