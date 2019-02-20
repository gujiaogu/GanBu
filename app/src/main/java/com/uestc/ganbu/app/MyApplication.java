package com.uestc.ganbu.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.uestc.ganbu.entity.DaoMaster;
import com.uestc.ganbu.entity.DaoSession;

public class MyApplication extends Application {

    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
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
