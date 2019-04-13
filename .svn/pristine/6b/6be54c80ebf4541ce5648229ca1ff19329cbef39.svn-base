package com.uestc.ganbu.base;

import android.support.v7.widget.Toolbar;

import com.uestc.ganbu.R;

import butterknife.BindView;

public abstract class TitleActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    Toolbar mToolbar;

    @Override
    public void initView() {
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> finish());
    }
}
