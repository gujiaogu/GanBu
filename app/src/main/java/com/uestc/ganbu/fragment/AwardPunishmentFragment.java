package com.uestc.ganbu.fragment;

import android.os.Bundle;

import com.uestc.ganbu.R;
import com.uestc.ganbu.base.BaseFragment;

public class AwardPunishmentFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public AwardPunishmentFragment() {
    }
    public static AwardPunishmentFragment newInstance(String param1, String param2) {
        AwardPunishmentFragment fragment = new AwardPunishmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_award_punishment;
    }

    @Override
    public void initView() {

    }
}
