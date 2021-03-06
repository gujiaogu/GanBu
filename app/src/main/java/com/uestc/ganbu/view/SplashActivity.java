package com.uestc.ganbu.view;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.uestc.ganbu.MainActivity;
import com.uestc.ganbu.R;
import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.MobilePhoneEntity;
import com.uestc.ganbu.entity.MobilePhoneEntityDao;
import com.uestc.ganbu.util.SharedPreferenceUtil;
import com.uestc.ganbu.util.ToastUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
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
//                String mobile = activity.sharedPreferenceUtil.getString(LoginActivity.KEY_LOGIN_INFO);
//                if (TextUtils.isEmpty(mobile)) {
//                    Intent intent = new Intent(activity, LoginActivity.class);
//                    activity.startActivity(intent);
//                    activity.finish();
//                } else {
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
//            }
        }
    }

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        daoSession = ((MyApplication) getApplication()).getDaoSession();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SplashActivityPermissionsDispatcher.showStorageWithPermissionCheck(this);
    }

    private void startMain() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            imei = tm.getImei();
        } else {
            imei = tm.getDeviceId();
        }
        if (TextUtils.isEmpty(imei)) {
            ToastUtil.textToast(this, "应用无法获取您手机的唯一标识");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
            return;
        }
        new LoginTask().execute(imei);
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {

        private String deviceId = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                ToastUtil.textToast(SplashActivity.this, "您无法登录应用，请联系管理员");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 1000);
            }
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            deviceId = strings[0];
            boolean flag = false;
            QueryBuilder<MobilePhoneEntity> queryBuilder = daoSession.queryBuilder(MobilePhoneEntity.class);
            List<MobilePhoneEntity> list = queryBuilder.where(MobilePhoneEntityDao.Properties.Mobile.eq(deviceId)).build().list();
            if (list != null && list.size() > 0) {
                flag = true;
            }
            return flag;
        }
    }

    @NeedsPermission({Manifest.permission.READ_PHONE_STATE})
    void showStorage() {
        startMain();
    }

    @OnShowRationale({Manifest.permission.READ_PHONE_STATE})
    void showRationaleForStorage(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("我们需要一些基本权限来保证应用正常运行")
                .setPositiveButton("允许", (dialog, which) -> request.proceed())
                .setNegativeButton("拒绝", (dialog, which) -> request.cancel())
                .show().setCanceledOnTouchOutside(false);
    }

    @OnPermissionDenied({Manifest.permission.READ_PHONE_STATE})
    void showDeniedForStorage() {
        ToastUtil.textToast(this, "您没有提供基本的权限供应用运行，请退出。");
    }

    @OnNeverAskAgain({Manifest.permission.READ_PHONE_STATE})
    void showNeverAskForStorage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setMessage("我们需要一些基本权限来保证应用正常运行");
        builder.setPositiveButton("去设置", (dialog, which) -> {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            startActivity(intent);
            dialog.dismiss();
        });
        Dialog settingDialog = builder.show();
        settingDialog.setCanceledOnTouchOutside(false);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

}
