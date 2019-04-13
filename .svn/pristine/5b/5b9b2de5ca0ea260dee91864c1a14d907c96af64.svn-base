package com.uestc.ganbu.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.uestc.ganbu.R;
import com.uestc.ganbu.adapter.SearchAdapter;
import com.uestc.ganbu.base.OnRecyclerViewItemClickListener;
import com.uestc.ganbu.base.TitleActivity;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.CadreInfoDao;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.util.ItemDivider;
import com.uestc.ganbu.util.ToastUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;

public class QueryUserListActivity extends TitleActivity implements OnRecyclerViewItemClickListener<CadreInfo> {

    public static final String KEY_SEARCH_TEXT = "key_search_text";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.query_edit)
    EditText mEdit;
    @BindView(R.id.query_search)
    Button mBtnSearch;

    private DaoSession daoSession;
    private SearchAdapter mAdapter;
    private String searchText = "";

    @Override
    public int setContentViewId() {
        return R.layout.activity_query_user_list;
    }

    @Override
    public void initView() {
        super.initView();
        daoSession = application.getDaoSession();
        searchText = getIntent().getStringExtra(KEY_SEARCH_TEXT);
        initList();
        if (!TextUtils.isEmpty(searchText)) {
            mEdit.setText(searchText);
            mEdit.setSelection(searchText.length());
            new SearchTask().execute(searchText);
        }

        mBtnSearch.setOnClickListener(v -> {
            String text = mEdit.getText().toString().trim();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            new SearchTask().execute(text);
        });
    }

    @Override
    public void onRecyclerViewItemClicked(CadreInfo entity) {
        Intent intent = new Intent(this, CadreInfoActivity.class);
        intent.putExtra(CadreInfoActivity.KEY_CADRE_INFO, entity);
        startActivity(intent);
    }

    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), (int) mRes.getDimension(R.dimen.item_divider_padding)));
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SearchAdapter(mCtx);
        mAdapter.setListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    private class SearchTask extends AsyncTask<String, Void, List<CadreInfo>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<CadreInfo> cadreInfos) {
            super.onPostExecute(cadreInfos);
            if (cadreInfos != null && cadreInfos.size() > 0) {
                mAdapter.setNewData(cadreInfos);
            }
        }

        @Override
        protected List<CadreInfo> doInBackground(String... strings) {
            String param = "%" + strings[0] + "%";
            QueryBuilder<CadreInfo> cadreQuery = daoSession.queryBuilder(CadreInfo.class);
            List<CadreInfo> list = cadreQuery.whereOr(CadreInfoDao.Properties.Name.like(param),
                    CadreInfoDao.Properties.IdNumber.like(param)).build().list();
            return list;
        }
    }
}
