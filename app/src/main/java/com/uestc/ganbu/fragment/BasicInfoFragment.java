package com.uestc.ganbu.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.BaseFragment;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.util.StreamUtil;

import butterknife.BindView;

public class BasicInfoFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.info_name)
    TextView mName;
    @BindView(R.id.info_gender)
    TextView mGender;
    @BindView(R.id.info_birthday)
    TextView mBirthday;
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
    @BindView(R.id.info_full_time_major)
    TextView mFullTimeMajor;
    @BindView(R.id.info_party_time_degree)
    TextView mPartTimeDegree;
    @BindView(R.id.info_party_time_college)
    TextView mPartTimeCollege;
    @BindView(R.id.info_party_time_major)
    TextView mPartTimeMajor;
    @BindView(R.id.info_current_position)
    TextView mCurrentPosition;
    @BindView(R.id.info_future_position)
    TextView mFuturePosition;
    @BindView(R.id.info_remove_position)
    TextView mRemovePosition;
    @BindView(R.id.info_remove_cause)
    TextView mRemoveCause;

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
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_basic_info;
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
            mBirthday.setText(birthday.substring(0, birthday.indexOf(" ")));
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
        String workTime = entity.getWorkTime();
        if (!TextUtils.isEmpty(workTime)) {
            mWorkTime.setText(workTime.substring(0, workTime.indexOf(" ")));
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

        mFullTimeCollege.setText(getTrueString(entity.getFullTimeSchool()));
        mFullTimeMajor.setText(getTrueString(entity.getFullTimeMajor()));
        String degreePart = entity.getInServiceDegree();
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
        mPartTimeCollege.setText(getTrueString(entity.getInServiceSchool()));
        mPartTimeMajor.setText(getTrueString(entity.getInServiceMajor()));
        mCurrentPosition.setText(getTrueString(entity.getPostTitleDesc()));
    }

    private String getTrueString(String param) {
        if (TextUtils.isEmpty(param)) {
            return "";
        }
        return param;
    }
}
