package com.uestc.ganbu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.uestc.ganbu.fragment.FragmentWrapper;

import java.util.List;

/**
 * Created by summer on 2016/6/30.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private List<FragmentWrapper> listWrapper;

    public TabPagerAdapter(FragmentManager fm, List<FragmentWrapper> listWrapper) {
        super(fm);
        this.listWrapper = listWrapper;
    }

    @Override
    public Fragment getItem(int position) {
        return listWrapper.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return listWrapper.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listWrapper.get(position%listWrapper.size()).getName();
    }
}
