package com.esp.mcbooks;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.*;

import java.util.ArrayList;

public class MyGiftPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> titles;

    public MyGiftPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        titles = new ArrayList<>();
    }

    public void add(String title) {
        titles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new MyGiftAllFragment();
        } else if (position == 1) {
            fragment = new MyGiftAudioFragment();
        } else if (position == 2) {
            fragment = new MyGiftVideoFragment();
        } else if (position == 3) {
            fragment = new MyGiftEbookFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
