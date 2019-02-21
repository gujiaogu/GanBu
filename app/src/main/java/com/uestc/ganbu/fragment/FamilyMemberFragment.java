package com.uestc.ganbu.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.adapter.FamilyAdapter;
import com.uestc.ganbu.adapter.ResumeAdapter;
import com.uestc.ganbu.base.BaseFragment;
import com.uestc.ganbu.entity.CadreFamily;
import com.uestc.ganbu.entity.CadreFamilyDao;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.CadreResume;
import com.uestc.ganbu.entity.CadreResumeDao;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.util.ItemDivider;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import butterknife.BindView;

public class FamilyMemberFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CadreInfo entity;
    private FamilyAdapter mAdapter;
    private DaoSession daoSession;

    public FamilyMemberFragment() {
    }

    public static FamilyMemberFragment newInstance(CadreInfo param1) {
        FamilyMemberFragment fragment = new FamilyMemberFragment();
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
        return R.layout.fragment_family_member;
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
        mAdapter = new FamilyAdapter(mCtx, application.getHelper().getReadableDatabase());
        recyclerView.setAdapter(mAdapter);

        if (entity == null) {
            return;
        }
        new FamilyTask().execute(String.valueOf(entity.get_id()));
    }

    private class FamilyTask extends AsyncTask<String, Void, List<CadreFamily>> {
        @Override
        protected List<CadreFamily> doInBackground(String... strings) {
            String cadreId = strings[0];
            QueryBuilder<CadreFamily> familyQuery = daoSession.queryBuilder(CadreFamily.class);
            List<CadreFamily> list = familyQuery.where(CadreFamilyDao.Properties.CadreId.eq(cadreId)).build().list();
            return list;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<CadreFamily> list) {
            super.onPostExecute(list);
            if (list != null && list.size() > 0) {
                mAdapter.setNewData(list);
            }
        }
    }
}
