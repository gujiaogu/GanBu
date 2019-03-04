package com.uestc.ganbu.fragment;

import android.os.Bundle;
import android.widget.ImageView;

import com.uestc.ganbu.BuildConfig;
import com.uestc.ganbu.R;
import com.uestc.ganbu.app.GlideApp;
import com.uestc.ganbu.base.BaseFragment;
import com.uestc.ganbu.entity.CadreInfo;

import butterknife.BindView;

public class PhotoFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.photo)
    ImageView mPhoto;

    private CadreInfo mParam1;

    public PhotoFragment() {
    }
    public static PhotoFragment newInstance(CadreInfo param1) {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_photo;
    }

    @Override
    public void initView() {
        GlideApp.with(this).load(BuildConfig.IP + mParam1.getPhoto()).into(mPhoto);
    }
}
