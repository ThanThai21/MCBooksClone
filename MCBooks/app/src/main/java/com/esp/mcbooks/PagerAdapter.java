package com.esp.mcbooks;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> titles;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        titles = new ArrayList<String>();
    }


    public void add(String title) {
        titles.add(title);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new LearningOverviewFragment();
        } else if (position == 1){
            fragment = new LearningStudyFragment();
        } else if (position == 2){
            fragment = new LearningTaskFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
