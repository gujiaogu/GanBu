package com.uestc.ganbu;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.uestc.ganbu.adapter.OrgAdapter;
import com.uestc.ganbu.adapter.SearchOrgAdapter;
import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.base.OnRecyclerViewItemClickListener;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.CadreInfoDao;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.OrgEntity;
import com.uestc.ganbu.entity.OrgEntityDao;
import com.uestc.ganbu.util.ItemDivider;
import com.uestc.ganbu.util.Stack;
import com.uestc.ganbu.view.CadreInfoActivity;
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
    @BindView(R.id.org_list)
    RecyclerView mOrgList;

    private DaoSession daoSession;
    private SearchOrgAdapter mAdapter;
    private OrgAdapter orgAdapter;
    private Resources mRes;
    private Stack<OrgEntity> stack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        daoSession = ((MyApplication) getApplication()).getDaoSession();
        mRes = getResources();
        initList();
        initText();
        initOrgList();
        mText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (TextUtils.isEmpty(text)) {
                    mAdapter.clear();
                }
            }
        });
    }

    @Override
    public void onRecyclerViewItemClicked(OrgEntity entity) {
        Intent intent = new Intent(this, OrgListActivity.class);
        intent.putExtra(OrgListActivity.KEY_PARAM, entity.get_id());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (stack.size() > 1) {
            pop();
        } else {
            super.onBackPressed();
        }
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

    private class OrgTask2 extends AsyncTask<String, Void, List<Object>> {

        @Override
        protected List<Object> doInBackground(String... strings) {
            ArrayList<Object> result = new ArrayList<>();
            String parentId = strings[0];
            if (TextUtils.isEmpty(parentId)) {
                return new ArrayList<>();
            }
            QueryBuilder<OrgEntity> orgQuery = daoSession.queryBuilder(OrgEntity.class);
            List<OrgEntity> listOrg = orgQuery.where(OrgEntityDao.Properties.BS07.eq(parentId)).build().list();
            QueryBuilder<CadreInfo> cadreQuery = daoSession.queryBuilder(CadreInfo.class);
            List<CadreInfo> listCadre = cadreQuery.where(CadreInfoDao.Properties.OrgId.eq(parentId)).build().list();
            result.addAll(listOrg);
            result.addAll(listCadre);
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Object> result) {
            super.onPostExecute(result);
            orgAdapter.setNewData(result);
        }
    }

    private void initText() {
        QueryBuilder<OrgEntity> orgQuery = daoSession.queryBuilder(OrgEntity.class);
        List<OrgEntity> listOrg = orgQuery.where(OrgEntityDao.Properties._id.eq(1)).build().list();
        if (listOrg != null && listOrg.size() == 1) {
            OrgEntity firstOrg = listOrg.get(0);
            stack.push(firstOrg);
            new OrgTask2().execute(String.valueOf(firstOrg.get_id()));
        }
    }

    private void initOrgList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mOrgList.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), (int) mRes.getDimension(R.dimen.item_divider_padding)));
        mOrgList.setLayoutManager(layoutManager);
        orgAdapter = new OrgAdapter(this);
        orgAdapter.setListener(new OnRecyclerViewItemClickListener<Object>() {
            @Override
            public void onRecyclerViewItemClicked(Object entity) {
                if (entity instanceof OrgEntity) {
                    OrgEntity orgEntity = (OrgEntity) entity;
                    push(orgEntity);
                } else if (entity instanceof CadreInfo) {
                    CadreInfo cadreInfo = (CadreInfo) entity;
                    Intent intent = new Intent(MainActivity.this, CadreInfoActivity.class);
                    intent.putExtra(CadreInfoActivity.KEY_CADRE_INFO, cadreInfo);
                    startActivity(intent);
                }
            }
        });
        mOrgList.setAdapter(orgAdapter);
    }

    private void push(OrgEntity orgEntity) {
        stack.push(orgEntity);
        new OrgTask2().execute(String.valueOf(orgEntity.get_id()));
    }

    private void pop() {
        stack.pop();
        OrgEntity orgEntity = stack.getTop();
        new OrgTask2().execute(String.valueOf(orgEntity.get_id()));
    }
}
