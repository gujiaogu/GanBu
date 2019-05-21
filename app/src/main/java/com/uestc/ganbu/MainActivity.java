package com.uestc.ganbu;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
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
import com.uestc.ganbu.entity.CadreAppointAndDismiss;
import com.uestc.ganbu.entity.CadreAppointAndDismissDao;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.CadreInfoDao;
import com.uestc.ganbu.entity.DaoSession;
import com.uestc.ganbu.entity.OrgEntity;
import com.uestc.ganbu.entity.OrgEntityDao;
import com.uestc.ganbu.util.ItemDivider;
import com.uestc.ganbu.util.Stack;
import com.uestc.ganbu.util.StreamUtil;
import com.uestc.ganbu.view.CadreInfoActivity;
import com.uestc.ganbu.view.OrgListActivity;
import com.uestc.ganbu.view.QueryUserListActivity;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

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
            List<OrgEntity> listOrg = orgQuery.where(OrgEntityDao.Properties.BS07.eq(parentId))
                    .orderAsc(OrgEntityDao.Properties.Sort).build().list();

//            QueryBuilder<CadreInfo> cadreQuery = daoSession.queryBuilder(CadreInfo.class);
//            cadreQuery.join(CadreAppointAndDismiss.class, CadreAppointAndDismissDao.Properties.CadreId)
//                    .where(CadreAppointAndDismissDao.Properties.OrgId.eq(parentId));
//            List<CadreInfo> listCadres = cadreQuery
//                    .orderAsc(CadreInfoDao.Properties.PostLevel)
//                    .orderAsc(CadreInfoDao.Properties.ExtAttribute09)
//                    .orderAsc(CadreInfoDao.Properties.PostLevelTime)
//                    .build().list();

            List<CadreInfo> listCadre = new ArrayList<>();
//            Cursor cursor = daoSession.getDatabase().rawQuery("" +
//                    "select *, tc07.C0714 as seq from tc01 join tc07 on tc01.BS01=tc07.C0711 " +
//                    "where tc07.A0711=? group by tc01.BS01 order by seq ASC, tc01.A0901 ASC, tc01.C0113 ASC", new String[]{parentId});

            String sql = "select " +
                    "T.\"BS01\",T.\"BS02\",T.\"BS03\",T.\"BS04\",T.\"BS05\",T.\"BS06\"," +
                    "T.\"A0101\",T.\"A0104\",T.\"A0107\",T.\"A0111\",T.\"A0114\",T.\"A0117\",T.\"A0121\",T.\"A0124\",T.\"A0127\",T.\"A0141\",T.\"A0148\",T.\"A0171\",T.\"A0177\",T.\"A2205\",T.\"A2210\",T.\"A1005\",T.\"A0703\",T.\"A0704\"  as postDesc ,T.\"A0901\",T.\"A0708\",T.\"A0711\"," +
                    "T.\"C0101\",T.\"C0102\",T.\"C0103\",T.\"C0104\",T.\"C0105\",T.\"C0106\",T.\"C0107\",T.\"C0108\",T.\"C0109\",T.\"C0110\",T.\"C0111\",T.\"C0112\",T.\"C0113\",T.\"C0114\",T.\"C0115\",T.\"C0180\",T.\"C0181\",T.\"C0182\",T.\"C0183\",T.\"C0184\",T.\"C0185\",T.\"C0186\",T.\"C0187\",T.\"C0188\",T.\"C0189\",T.\"C0190\"" +
                    ", tc07.C0714 as seq " +
                    "from tc01 T join tc07 on T.BS01=tc07.C0711 " +
                    "where tc07.A0711=? group by T.BS01 order by seq ASC, T.A0901 ASC, T.C0113 ASC";
            Cursor cursor = daoSession.getDatabase().rawQuery(sql, new String[]{parentId});

            if (cursor.getCount() > 0) {
                CadreInfo cadreInfo;
                while (cursor.moveToNext()) {
                    cadreInfo = new CadreInfo();
                    cadreInfo.set_id(cursor.getLong(cursor.getColumnIndex("BS01")));
                    cadreInfo.setBS02(cursor.getString(cursor.getColumnIndex("BS02")));
                    cadreInfo.setBS03(cursor.getString(cursor.getColumnIndex("BS03")));
                    cadreInfo.setBS04(cursor.getLong(cursor.getColumnIndex("BS04")));
                    cadreInfo.setBS05(cursor.getLong(cursor.getColumnIndex("BS05")));
                    cadreInfo.setBS06(cursor.getInt(cursor.getColumnIndex("BS06")));

                    cadreInfo.setName(cursor.getString(cursor.getColumnIndex("A0101")));
                    cadreInfo.setFormerName(cursor.getString(cursor.getColumnIndex("A0104")));
                    cadreInfo.setSex(cursor.getString(cursor.getColumnIndex("A0107")));
                    cadreInfo.setBirthDay(cursor.getString(cursor.getColumnIndex("A0111")));
                    cadreInfo.setNativePlace(cursor.getString(cursor.getColumnIndex("A0114")));
                    cadreInfo.setBirthplace(cursor.getString(cursor.getColumnIndex("A0117")));
                    cadreInfo.setNation(cursor.getString(cursor.getColumnIndex("A0121")));
                    cadreInfo.setHealth(cursor.getString(cursor.getColumnIndex("A0124")));
                    cadreInfo.setMaritalStatus(cursor.getString(cursor.getColumnIndex("A0127")));
                    cadreInfo.setWorkTime(cursor.getString(cursor.getColumnIndex("A0141")));
                    cadreInfo.setPhone(cursor.getString(cursor.getColumnIndex("A0148")));
                    cadreInfo.setPlaceOfDomicile(cursor.getString(cursor.getColumnIndex("A0171")));
                    cadreInfo.setIdNumber(cursor.getString(cursor.getColumnIndex("A0177")));
                    cadreInfo.setPoliticalStatus(cursor.getString(cursor.getColumnIndex("A2205")));
                    cadreInfo.setJoinOrganizationTime(cursor.getString(cursor.getColumnIndex("A2210")));
                    cadreInfo.setTitleOfTechnicalPost(cursor.getString(cursor.getColumnIndex("A1005")));
                    cadreInfo.setPostTitle(cursor.getString(cursor.getColumnIndex("A0703")));
                    cadreInfo.setPostTitleDesc(cursor.getString(cursor.getColumnIndex("postDesc")));
                    cadreInfo.setPostLevel(cursor.getString(cursor.getColumnIndex("A0901")));
                    cadreInfo.setPostTitleTime(cursor.getString(cursor.getColumnIndex("A0708")));
                    cadreInfo.setOrgId(cursor.getString(cursor.getColumnIndex("A0711")));

                    cadreInfo.setIdentityType(cursor.getString(cursor.getColumnIndex("C0101")));
                    cadreInfo.setOtherIdentities(cursor.getString(cursor.getColumnIndex("C0102")));
                    cadreInfo.setFullTimeEducation(cursor.getString(cursor.getColumnIndex("C0103")));
                    cadreInfo.setFullTimeDegree(cursor.getString(cursor.getColumnIndex("C0104")));
                    cadreInfo.setInServiceEducation(cursor.getString(cursor.getColumnIndex("C0105")));
                    cadreInfo.setInServiceDegree(cursor.getString(cursor.getColumnIndex("C0106")));
                    cadreInfo.setFullTimeSchool(cursor.getString(cursor.getColumnIndex("C0107")));
                    cadreInfo.setFullTimeMajor(cursor.getString(cursor.getColumnIndex("C0108")));
                    cadreInfo.setInServiceSchool(cursor.getString(cursor.getColumnIndex("C0109")));
                    cadreInfo.setInServiceMajor(cursor.getString(cursor.getColumnIndex("C0110")));
                    cadreInfo.setSpecialty(cursor.getString(cursor.getColumnIndex("C0111")));
                    cadreInfo.setRewardAndPunishment(cursor.getString(cursor.getColumnIndex("C0112")));
                    cadreInfo.setPostLevelTime(cursor.getString(cursor.getColumnIndex("C0113")));
                    cadreInfo.setPhoto(cursor.getString(cursor.getColumnIndex("C0114")));
                    cadreInfo.setEvidence(cursor.getString(cursor.getColumnIndex("C0115")));
                    cadreInfo.setExtAttribute00(cursor.getString(cursor.getColumnIndex("C0180")));
                    cadreInfo.setExtAttribute01(cursor.getString(cursor.getColumnIndex("C0181")));
                    cadreInfo.setExtAttribute02(cursor.getString(cursor.getColumnIndex("C0182")));
                    cadreInfo.setExtAttribute03(cursor.getString(cursor.getColumnIndex("C0183")));
                    cadreInfo.setExtAttribute04(cursor.getString(cursor.getColumnIndex("C0184")));
                    cadreInfo.setExtAttribute05(cursor.getString(cursor.getColumnIndex("C0185")));
                    cadreInfo.setExtAttribute06(cursor.getString(cursor.getColumnIndex("C0186")));
                    cadreInfo.setExtAttribute07(cursor.getString(cursor.getColumnIndex("C0187")));
                    cadreInfo.setExtAttribute08(cursor.getString(cursor.getColumnIndex("C0188")));
                    cadreInfo.setExtAttribute09(cursor.getString(cursor.getColumnIndex("C0189")));
                    cadreInfo.setSeq(cursor.getInt(cursor.getColumnIndex("seq")));
                    cadreInfo.setCadreType(cursor.getString(cursor.getColumnIndex("C0190")));

                    listCadre.add(cadreInfo);
                }
            }
            StreamUtil.close(cursor);

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
