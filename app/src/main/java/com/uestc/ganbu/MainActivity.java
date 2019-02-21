package com.uestc.ganbu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.uestc.ganbu.view.OrgListActivity;
import com.uestc.ganbu.view.QueryUserListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectOrg(View view) {
        Intent intent = new Intent(this, OrgListActivity.class);
        startActivity(intent);
    }

    public void selectByName(View view) {
        Intent intent = new Intent(this, QueryUserListActivity.class);
        startActivity(intent);
    }
}
