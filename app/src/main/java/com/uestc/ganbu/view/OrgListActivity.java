package com.uestc.ganbu.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.adapter.OrgAdapter;
import com.uestc.ganbu.app.MyApplication;
import com.uestc.ganbu.base.OnRecyclerViewItemClickListener;
import com.uestc.ganbu.base.TitleActivity;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.CadreInfoDao;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.OrgEntity;
import com.uestc.ganbu.entity.OrgEntityDao;
import com.uestc.ganbu.util.ItemDivider;
import com.uestc.ganbu.util.Stack;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrgListActivity extends TitleActivity implements OnRecyclerViewItemClickListener<Object> {

    private static final String SEPARATOR = ">";

    private Stack<OrgEntity> stack = new Stack<>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.selected_org)
    TextView selectedOrg;
    @BindView(R.id.org_progress)
    ProgressBar mProgress;

    private DaoSession daoSession;
    private OrgAdapter mAdapter;

    @Override
    public void initView() {
        super.initView();
        daoSession = ((MyApplication) getApplication()).getDaoSession();
        initText();
        initList();
    }

    @Override
    public int setContentViewId() {
        return R.layout.activity_org_list;
    }

    @Override
    public void onRecyclerViewItemClicked(Object entity) {
        if (entity instanceof OrgEntity) {
            OrgEntity orgEntity = (OrgEntity) entity;
            push(orgEntity);
        } else if (entity instanceof CadreInfo) {
            CadreInfo cadreInfo = (CadreInfo) entity;
            Intent intent = new Intent(this, CadreInfoActivity.class);
            intent.putExtra(CadreInfoActivity.KEY_CADRE_INFO, cadreInfo);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (stack.size() > 1) {
            pop();
        } else {
            super.onBackPressed();
        }
    }

    private void initList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), (int) mRes.getDimension(R.dimen.item_divider_padding)));
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new OrgAdapter(this);
        mAdapter.setListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    private class OrgTask extends AsyncTask<String, Void, List<Object>> {

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
            mProgress.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Object> result) {
            super.onPostExecute(result);
            mAdapter.setNewData(result);
            mProgress.setVisibility(View.INVISIBLE);
        }
    }

    private void initText() {
        QueryBuilder<OrgEntity> orgQuery = daoSession.queryBuilder(OrgEntity.class);
        List<OrgEntity> listOrg = orgQuery.where(OrgEntityDao.Properties._id.eq(1)).build().list();
        if (listOrg != null && listOrg.size() == 1) {
            OrgEntity firstOrg = listOrg.get(0);
            stack.push(firstOrg);
            selectedOrg.setText(firstOrg.getName());
            new OrgTask().execute(String.valueOf(firstOrg.get_id()));
        }
    }

    private void push(OrgEntity orgEntity) {
        stack.push(orgEntity);
        selectedOrg.setText(selectedOrg.getText().toString() + SEPARATOR + orgEntity.getName());
        new OrgTask().execute(String.valueOf(orgEntity.get_id()));
    }

    private void pop() {
        stack.pop();
        OrgEntity orgEntity = stack.getTop();
        String text = selectedOrg.getText().toString();
        selectedOrg.setText(text.substring(0, text.lastIndexOf(SEPARATOR)));
        new OrgTask().execute(String.valueOf(orgEntity.get_id()));
    }
}
