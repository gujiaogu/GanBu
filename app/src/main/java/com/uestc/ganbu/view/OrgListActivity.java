package com.uestc.ganbu.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.uestc.ganbu.R;
import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.OrgEntity;

import java.util.List;

public class OrgListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_list);
        DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();
        new Thread(() -> {
            List<OrgEntity> list = daoSession.loadAll(OrgEntity.class);
            Log.d("====", "====");
        }).start();
    }
}
