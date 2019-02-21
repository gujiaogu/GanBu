package com.uestc.ganbu.view;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uestc.ganbu.MainActivity;
import com.uestc.ganbu.R;
import com.uestc.ganbu.util.AssetsDatabaseManager;
import com.uestc.ganbu.util.SharedPreferenceUtil;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    private static final String KEY_VERSION_NAME = "key_version_name";

    private final AnimHandler animHandler = new AnimHandler(this);
    private static final class AnimHandler extends Handler {

        final WeakReference<SplashActivity> reference;

        AnimHandler(SplashActivity activity) {
            super();
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity activity = reference.get();
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        }
    }
    private SharedPreferenceUtil sharedUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedUtil = new SharedPreferenceUtil(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AssetsDatabaseManager assetsManager = new AssetsDatabaseManager(this);
        if (!assetsManager.isDatabaseExist() || isNeedToUpdate()) {
            boolean isSuccess = assetsManager.copyAssetsToFilesystem();
            if (isSuccess) {
                String versionName = getVersionName();
                sharedUtil.putString(KEY_VERSION_NAME, versionName);
            }
        }
        startMain();
    }

    private void startMain() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                animHandler.sendMessage(Message.obtain());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private boolean isNeedToUpdate() {
        boolean flag = false;
        String versionName = getVersionName();
        String versionNamePre = sharedUtil.getString(KEY_VERSION_NAME);
        if (!versionName.equals(versionNamePre)) {
            flag = true;
        }
        return flag;
    }

    private String getVersionName() {
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
