package com.uestc.ganbu.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.multidex.MultiDexApplication;

import com.github.promeg.pinyinhelper.Pinyin;
import com.uestc.ganbu.entity.DaoMaster;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.UserInfo;
import com.uestc.ganbu.util.AssetsDatabaseManager;
import com.uestc.ganbu.util.SharedPreferenceUtil;
import com.uestc.ganbu.util.StreamUtil;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends MultiDexApplication {

    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper helper;
    private SharedPreferenceUtil sharedUtil;
    private static final String KEY_VERSION_NAME = "key_version_name";
    private static final String DB_NAME = "ganbu.db";

    @Override
    public void onCreate() {
        super.onCreate();
        sharedUtil = new SharedPreferenceUtil(this);
        initDb();//这三个初始化语句顺序不能变。
        initGreenDao();
    }

    private void initDb() {
        AssetsDatabaseManager assetsManager = new AssetsDatabaseManager(this);
        if (!assetsManager.isDatabaseExist() || isNeedToUpdate()) {
            boolean isSuccess = assetsManager.copyAssetsToFilesystem();
            if (isSuccess) {
                DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, DB_NAME);
                SQLiteDatabase db = devOpenHelper.getWritableDatabase();
                checkPinyin(db);
                new PinyinTask().execute();
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
        helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
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

    private void checkPinyin(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("select * from tc01 limit 1", null);
        if (cursor != null && cursor.getColumnIndex("pinyin") < 0) {
            db.execSQL("alter table tc01 add pinyin text");
        }
        StreamUtil.close(cursor);
    }

    private class PinyinTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.this, DB_NAME);
            SQLiteDatabase dbff = devOpenHelper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(dbff);
            Database db = daoMaster.newSession().getDatabase();


            List<UserInfo> users = new ArrayList<>();
            Cursor cursor = db.rawQuery("select t.BS01, t.A0101 from tc01 t ", null);
            int count = cursor.getCount();
            if (count > 0) {
                UserInfo userInfo;
                while (cursor.moveToNext()) {
                    userInfo = new UserInfo();
                    userInfo.setBS01(cursor.getLong(cursor.getColumnIndex("BS01")));
                    userInfo.setA0101(cursor.getString(cursor.getColumnIndex("A0101")));
                    users.add(userInfo);
                }
            }
            try {
                cursor.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (UserInfo userInfo : users) {
                String name = userInfo.getA0101();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < name.length(); i ++) {
                    builder.append(Pinyin.toPinyin(name.charAt(i)).charAt(0));
                }
                db.execSQL("update tc01 set pinyin=? where BS01=?", new String[]{builder.toString(), String.valueOf(userInfo.getBS01())});
            }

            String versionName = getVersionName();
            sharedUtil.putString(KEY_VERSION_NAME, versionName);
            return null;
        }
    }
}
