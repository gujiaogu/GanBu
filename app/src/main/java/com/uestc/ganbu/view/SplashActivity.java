package com.uestc.ganbu.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uestc.ganbu.MainActivity;
import com.uestc.ganbu.R;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

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
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMain();
    }

    private void startMain() {
        new Thread(() -> {
            try {
                Thread.sleep(500);
                animHandler.sendMessage(Message.obtain());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
