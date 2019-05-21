package com.uestc.ganbu.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.BaseFragment;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.entity.EventMarriage;
import com.uestc.ganbu.util.EventBusUtil;
import com.uestc.ganbu.util.StreamUtil;
import com.uestc.ganbu.util.TimeFormatUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class BasicInfoFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.info_name)
    TextView mName;
    @BindView(R.id.info_gender)
    TextView mGender;
    @BindView(R.id.info_birthday)
    TextView mBirthday;
    @BindView(R.id.info_marriage)
    TextView mMarriage;
    @BindView(R.id.info_political)
    TextView mPolitical;
    @BindView(R.id.info_nation)
    TextView mNation;
    @BindView(R.id.info_ji_guan)
    TextView mJiGuan;
    @BindView(R.id.info_birth_place)
    TextView mBirthPlace;
    @BindView(R.id.info_join_time)
    TextView mJoinTime;
    @BindView(R.id.info_work_time)
    TextView mWorkTime;
    @BindView(R.id.info_health_status)
    TextView mHealthStatus;
    @BindView(R.id.info_tech_position)
    TextView mTechPosition;
    @BindView(R.id.info_tech_speciality)
    TextView mTechSpeciality;
    @BindView(R.id.info_full_time_degree)
    TextView mFullTimeDegree;
    @BindView(R.id.info_full_time_college)
    TextView mFullTimeCollege;
    @BindView(R.id.info_party_time_degree)
    TextView mPartTimeDegree;
    @BindView(R.id.info_party_time_college)
    TextView mPartTimeCollege;
    @BindView(R.id.info_current_position)
    TextView mCurrentPosition;
    @BindView(R.id.info_current_position_time)
    TextView mCurrentPositionTime;
    @BindView(R.id.info_current_level_time)
    TextView mCurrentLevelTime;

    private CadreInfo entity;

    public BasicInfoFragment() {
    }

    public static BasicInfoFragment newInstance(CadreInfo param1) {
        BasicInfoFragment fragment = new BasicInfoFragment();
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
        EventBusUtil.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_basic_info;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refreshList(EventMarriage event) {
        mMarriage.setText("已婚");
    }

    @Override
    public void initView() {
        if (entity == null) {
            return;
        }
        SQLiteDatabase db = application.getHelper().getReadableDatabase();

        mName.setText(getTrueString(entity.getName()));
        mGender.setText("1".equals(entity.getSex()) ? "男" : "女");
        String birthday = entity.getBirthDay();
        if (!TextUtils.isEmpty(birthday)) {
            try {
                mBirthday.setText(TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf6.parse(birthday)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(entity.getMaritalStatus())) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='25' and S0602=?", new String[]{entity.getMaritalStatus()});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    String tmp = cursor.getString(cursor.getColumnIndex("S0603"));
                    if (TextUtils.isEmpty(tmp)) {
                        mMarriage.setText("已婚");
                    } else {
                        mMarriage.setText("未婚");
                    }
                }
            }
            StreamUtil.close(cursor);
        }
        if (!TextUtils.isEmpty(entity.getPoliticalStatus())) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='20' and S0602=?", new String[]{entity.getPoliticalStatus()});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    mPolitical.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }
        if (!TextUtils.isEmpty(entity.getNation())) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='2' and S0602=?", new String[]{entity.getNation()});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    mNation.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }
        mJiGuan.setText(getTrueString(entity.getNativePlace()));
        mBirthPlace.setText(getTrueString(entity.getBirthplace()));
        String joinTime = entity.getJoinOrganizationTime();
        if (!TextUtils.isEmpty(joinTime)) {
            try {
                mJoinTime.setText(TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf6.parse(joinTime)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String workTime = entity.getWorkTime();
        if (!TextUtils.isEmpty(workTime)) {
            try {
                mWorkTime.setText(TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf6.parse(workTime)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String healthStatus = entity.getHealth();
        if (!TextUtils.isEmpty(healthStatus)) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='21' and S0602=?", new String[]{healthStatus});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    mHealthStatus.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }

        String techTitle = entity.getTitleOfTechnicalPost();
        if (!TextUtils.isEmpty(techTitle)) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='28' and S0602=?", new String[]{techTitle});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    mTechPosition.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }
        mTechSpeciality.setText(getTrueString(entity.getSpecialty()));

        String degree = entity.getFullTimeEducation();
        if (!TextUtils.isEmpty(degree)) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='29' and S0602=?", new String[]{degree});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    mFullTimeDegree.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }

        mFullTimeCollege.setText(getTrueString(entity.getFullTimeSchool()) + getTrueString(entity.getFullTimeMajor()));
        String degreePart = entity.getInServiceEducation();
        if (!TextUtils.isEmpty(degreePart)) {
            Cursor cursor = db.rawQuery("SELECT * FROM ts06 WHERE S0601='29' and S0602=?", new String[]{degreePart});
            int count = cursor.getCount();
            if (count > 0) {
                if (cursor.moveToFirst()) {
                    mPartTimeDegree.setText(cursor.getString(cursor.getColumnIndex("S0603")));
                }
            }
            StreamUtil.close(cursor);
        }
        mPartTimeCollege.setText(getTrueString(entity.getInServiceSchool()) + getTrueString(entity.getInServiceMajor()));
        mCurrentPosition.setText(getTrueString(entity.getPostTitleDesc()));

        String currentPositionTime = entity.getPostTitleTime();
        if (!TextUtils.isEmpty(currentPositionTime)) {
            int index = currentPositionTime.indexOf(" ");
            if (index < 0) {
                index = currentPositionTime.length();
            }
            try {
                mCurrentPositionTime.setText(TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf4.parse(currentPositionTime)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String currentLevelTime = entity.getPostLevelTime();
        if (!TextUtils.isEmpty(currentLevelTime)) {
            try {
                mCurrentLevelTime.setText(TimeFormatUtil.sdf4.format(TimeFormatUtil.sdf6.parse(currentLevelTime)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getTrueString(String param) {
        if (TextUtils.isEmpty(param)) {
            return "";
        }
        return param;
    }
}
