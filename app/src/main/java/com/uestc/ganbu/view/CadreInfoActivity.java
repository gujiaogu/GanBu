package com.uestc.ganbu.view;

import android.support.v4.app.Fragment;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.BaseActivity;
import com.uestc.ganbu.entity.CadreInfo;
import com.uestc.ganbu.fragment.AwardPunishmentFragment;
import com.uestc.ganbu.fragment.BasicInfoFragment;
import com.uestc.ganbu.fragment.CheckResultFragment;
import com.uestc.ganbu.fragment.FamilyMemberFragment;
import com.uestc.ganbu.fragment.FragmentWrapper;
import com.uestc.ganbu.fragment.ResumeFragment;
import com.uestc.ganbu.fragment.TabFragmentContainer;

import java.util.ArrayList;

public class CadreInfoActivity extends BaseActivity {

    public static final String KEY_CADRE_INFO = "key_cadre_info";

    private CadreInfo entity;

    @Override
    public int setContentViewId() {
        return R.layout.activity_cadre_info;
    }

    @Override
    public void initView() {
        entity = getIntent().getParcelableExtra(KEY_CADRE_INFO);
        ArrayList<FragmentWrapper> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentWrapper(0, "基础信息", BasicInfoFragment.newInstance(entity)));
        fragmentList.add(new FragmentWrapper(1, "简历", ResumeFragment.newInstance(entity)));
        fragmentList.add(new FragmentWrapper(2, "奖惩情况", AwardPunishmentFragment.newInstance("", "")));
        fragmentList.add(new FragmentWrapper(3, "年度考核结果", CheckResultFragment.newInstance(entity)));
        fragmentList.add(new FragmentWrapper(4, "家庭成员", FamilyMemberFragment.newInstance(entity)));
        Fragment fragmentContainer = TabFragmentContainer.getInstance(fragmentList, mRes.getString(R.string.title_activity_cadre_info));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.place_holder, fragmentContainer).commitAllowingStateLoss();
    }
}
