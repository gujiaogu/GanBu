package com.uestc.ganbu;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.uestc.ganbu.adapter.SearchOrgAdapter;
import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.base.OnRecyclerViewItemClickListener;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.OrgEntity;
import com.uestc.ganbu.entity.OrgEntityDao;
import com.uestc.ganbu.util.ItemDivider;
import com.uestc.ganbu.view.OrgListActivity;
import com.uestc.ganbu.view.QueryUserListActivity;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener<OrgEntity> {

    @BindView(R.id.edit_text_1)
    EditText mText1;
    @BindView(R.id.edit_text_2)
    EditText mText2;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DaoSession daoSession;
    private SearchOrgAdapter mAdapter;
    private Resources mRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        daoSession = ((MyApplication) getApplication()).getDaoSession();
        mRes = getResources();
        initList();
    }

    @Override
    public void onRecyclerViewItemClicked(OrgEntity entity) {
        Intent intent = new Intent(this, OrgListActivity.class);
        intent.putExtra(OrgListActivity.KEY_PARAM, entity.get_id());
        startActivity(intent);
    }

    public void selectOrg(View view) {
        String org = mText2.getText().toString().trim();
        if (TextUtils.isEmpty(org)) {
            Intent intent = new Intent(this, OrgListActivity.class);
            startActivity(intent);
            mAdapter.clear();
        } else {
            new OrgTask().execute(org);
        }
    }

    public void selectByName(View view) {
        String name = mText1.getText().toString().trim();
        Intent intent = new Intent(this, QueryUserListActivity.class);
        intent.putExtra(QueryUserListActivity.KEY_SEARCH_TEXT, name);
        startActivity(intent);
    }

    private void initList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), 0));
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SearchOrgAdapter(this);
        mAdapter.setListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    private class OrgTask extends AsyncTask<String, Void, List<OrgEntity>> {

        @Override
        protected List<OrgEntity> doInBackground(String... strings) {
            String orgName = strings[0];
            if (TextUtils.isEmpty(orgName)) {
                return new ArrayList<>();
            }
            QueryBuilder<OrgEntity> orgQuery = daoSession.queryBuilder(OrgEntity.class);
            return orgQuery.where(OrgEntityDao.Properties.Name.like("%" + orgName + "%")).build().list();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<OrgEntity> result) {
            super.onPostExecute(result);
            mAdapter.setNewData(result);
        }
    }
}
