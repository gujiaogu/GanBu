package com.uestc.ganbu.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.uestc.ganbu.MainActivity;
import com.uestc.ganbu.R;
import com.uestc.ganbu.util.SharedPreferenceUtil;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferenceUtil sharedPreferenceUtil;
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
                String mobile = activity.sharedPreferenceUtil.getString(LoginActivity.KEY_LOGIN_INFO);
                if (TextUtils.isEmpty(mobile)) {
                    Intent intent = new Intent(activity, LoginActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                } else {
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
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

}
