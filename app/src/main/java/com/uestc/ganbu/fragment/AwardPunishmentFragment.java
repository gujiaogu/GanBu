package com.uestc.ganbu.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.uestc.ganbu.R;
import com.uestc.ganbu.adapter.AwardPunishmentAdapter;
import com.uestc.ganbu.adapter.CheckResultAdapter;
import com.uestc.ganbu.base.BaseFragment;
import com.uestc.ganbu.entity.CadreAppraisal;
import com.uestc.ganbu.entity.CadreAppraisalDao;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.CadrePunishment;
import com.uestc.ganbu.entity.CadreReward;
import com.uestc.ganbu.entity.CadreRewardDao;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.util.ItemDivider;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AwardPunishmentFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerView2)
    RecyclerView recyclerView2;

    private CadreInfo entity;
    private DaoSession daoSession;
    private AwardPunishmentAdapter mAdapter;

    private CheckResultAdapter mAdapter2;

    public AwardPunishmentFragment() {
    }
    public static AwardPunishmentFragment newInstance(CadreInfo param1) {
        AwardPunishmentFragment fragment = new AwardPunishmentFragment();
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
        return R.layout.fragment_award_punishment;
    }

    @Override
    public void initView() {
        daoSession = application.getDaoSession();
        initList();
        initList2();
    }

    private void initList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), (int) mRes.getDimension(R.dimen.item_divider_padding)));
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AwardPunishmentAdapter(mCtx, application.getHelper().getReadableDatabase());
        recyclerView.setAdapter(mAdapter);
        if (entity == null) {
            return;
        }
        new AwardPunishmentTask().execute(String.valueOf(entity.get_id()));
    }

    private class AwardPunishmentTask extends AsyncTask<String, Void, List<Object>> {
        @Override
        protected List<Object> doInBackground(String... strings) {
            ArrayList<Object> result = new ArrayList<>();
            String cadreId = strings[0];
            if (TextUtils.isEmpty(cadreId)) {
                return new ArrayList<>();
            }

            QueryBuilder<CadreReward> rewardBuilder = daoSession.queryBuilder(CadreReward.class);
            List<CadreReward> listReward = rewardBuilder
                    .where(CadreRewardDao.Properties.CadreId.eq(cadreId)).build().list();
            QueryBuilder<CadrePunishment> punishmentQuery = daoSession.queryBuilder(CadrePunishment.class);
            List<CadrePunishment> listPunishment = punishmentQuery.build().list();
            result.addAll(listReward);
            result.addAll(listPunishment);
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Object> objects) {
            super.onPostExecute(objects);
            mAdapter.setNewData(objects);
        }
    }

    private void initList2() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx, LinearLayoutManager.VERTICAL, false);
        recyclerView2.addItemDecoration(new ItemDivider(mRes.getDrawable(R.drawable.recycler_view_item_divider), (int) mRes.getDimension(R.dimen.item_divider_padding)));
        recyclerView2.setLayoutManager(layoutManager);
        mAdapter2 = new CheckResultAdapter(mCtx);
        recyclerView2.setAdapter(mAdapter2);

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
                mAdapter2.setNewData(list);
            }
        }
    }
}
