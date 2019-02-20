package com.uestc.ganbu.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.uestc.ganbu.R;
import com.uestc.ganbu.adapter.TabPagerAdapter;
import com.uestc.ganbu.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by summer on 2016/6/30.
 */
public class TabFragmentContainer extends BaseFragment {

    @BindView(R.id.news_container_fragment_tab_viewPager)
    ViewPager viewPager;// ViewPager对象
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.news_container_fragment_tab)
    TabLayout tabLayout;

    TabPagerAdapter pagerAdapter;
    List<FragmentWrapper> listWrapper;
    String name;
    public static Fragment getInstance(List<FragmentWrapper> listWrapper, String titleName){
        TabFragmentContainer mInstance = new TabFragmentContainer();
        mInstance.setNameAndId(listWrapper, titleName);
        return mInstance;
    }

    private void setNameAndId(List<FragmentWrapper> listWrapper, String titleName){
        this.listWrapper = listWrapper;
        this.name = titleName;
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_tab_news_container;
    }

    @Override
    public void initView() {
        initToolbar();
        if (listWrapper == null) {
            return;
        }
        for (int i = 0; i < listWrapper.size(); i ++){
            tabLayout.addTab(tabLayout.newTab().setText(listWrapper.get(i).getName()));
        }
        viewPager.setOffscreenPageLimit(6);
        if (listWrapper.size() < 4){
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            if (listWrapper.size() == 1){
                tabLayout.setVisibility(View.GONE);
            }
        } else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        pagerAdapter = new TabPagerAdapter(getActivity().getSupportFragmentManager(), listWrapper);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initToolbar() {
        mToolbar.setTitle(this.name);
        ((AppCompatActivity) mCtx).setSupportActionBar(mToolbar);
        ((AppCompatActivity) mCtx).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> mCtx.finish());

    }
}
