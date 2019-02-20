package com.uestc.ganbu.view;

import android.support.v7.widget.RecyclerView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.TitleActivity;

import butterknife.BindView;

public class QueryUserListActivity extends TitleActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public int setContentViewId() {
        return R.layout.activity_query_user_list;
    }

    @Override
    public void initView() {
        super.initView();
    }
}
