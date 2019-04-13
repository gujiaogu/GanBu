package com.uestc.ganbu.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.adapter.CheckResultAdapter;
import com.uestc.ganbu.base.BaseFragment;
import com.uestc.ganbu.entity.CadreAppraisal;
import com.uestc.ganbu.entity.CadreAppraisalDao;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.util.ItemDivider;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;

public class CheckResultFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CadreInfo entity;
    private CheckResultAdapter mAdapter;
    private DaoSession daoSession;

    public CheckResultFragment() {
    }
    public static CheckResultFragment newInstance(CadreInfo param1) {
        CheckResultFragment fragment = new CheckResultFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            entity = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_check_result;
    }

    @Override
    public void initView() {
        daoSession = application.getDaoSession();
        initList();
    }

    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), (int) mRes.getDimension(R.dimen.item_divider_padding)));
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new CheckResultAdapter(mCtx);
        recyclerView.setAdapter(mAdapter);

        if (entity == null) {
            return;
        }
        new CheckResultTask().execute(String.valueOf(entity.get_id()));
    }

    private class CheckResultTask extends AsyncTask<String, Void, List<CadreAppraisal>> {
        @Override
        protected List<CadreAppraisal> doInBackground(String... strings) {
            String cadreId = strings[0];
            QueryBuilder<CadreAppraisal> resumeQuery = daoSession.queryBuilder(CadreAppraisal.class);
            List<CadreAppraisal> list = resumeQuery.where(CadreAppraisalDao.Properties.C0611.eq(cadreId)).build().list();
            return list;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<CadreAppraisal> list) {
            super.onPostExecute(list);
            if (list != null && list.size() > 0) {
                mAdapter.setNewData(list);
            }
        }
    }
}
