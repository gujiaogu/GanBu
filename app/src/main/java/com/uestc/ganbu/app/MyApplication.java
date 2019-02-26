package com.uestc.ganbu.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDexApplication;

import com.uestc.ganbu.entity.DaoMaster;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.util.AssetsDatabaseManager;
import com.uestc.ganbu.util.SharedPreferenceUtil;

public class MyApplication extends MultiDexApplication {

    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper helper;
    private SharedPreferenceUtil sharedUtil;
    private static final String KEY_VERSION_NAME = "key_version_name";

    @Override
    public void onCreate() {
        super.onCreate();
        sharedUtil = new SharedPreferenceUtil(this);
        initDb();
        initGreenDao();
    }

    private void initDb() {
        AssetsDatabaseManager assetsManager = new AssetsDatabaseManager(this);
        if (!assetsManager.isDatabaseExist() || isNeedToUpdate()) {
            boolean isSuccess = assetsManager.copyAssetsToFilesystem();
            if (isSuccess) {
                String versionName = getVersionName();
                sharedUtil.putString(KEY_VERSION_NAME, versionName);
            }
        }
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

    private void initGreenDao() {
        helper = new DaoMaster.DevOpenHelper(this, "ganbu.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoMaster.DevOpenHelper getHelper() {
        return helper;
    }
}
