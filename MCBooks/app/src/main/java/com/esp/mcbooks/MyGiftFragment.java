package com.esp.mcbooks;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyGiftFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    MyGiftPagerAdapter pagerAdapter;
    String[] titleTablayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mygift, null);
        titleTablayout = new String[]{getString(R.string.all), getString(R.string.audio), getString(R.string.video),
                getString(R.string.ebook)};
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        FragmentManager fragmentManager = getChildFragmentManager();
        tabLayout = (TabLayout) view.findViewById(R.id.mygift_tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.mygift_viewpager);
        pagerAdapter = new MyGiftPagerAdapter(fragmentManager, getContext());
        pagerAdapter.add(getString(R.string.all));
        pagerAdapter.add(getString(R.string.audio));
        pagerAdapter.add(getString(R.string.video));
        pagerAdapter.add(getString(R.string.ebook));
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view0 = inflater.inflate(R.layout.custom_view_tab, null);
        TextView textViewTab0 = (TextView) view0.findViewById(R.id.learning_title_tabview);
        textViewTab0.setText(titleTablayout[0]);
        textViewTab0.setBackgroundResource(R.drawable.bg_tabview);
        tabLayout.getTabAt(0).setCustomView(textViewTab0);
        View view1 = inflater.inflate(R.layout.custom_view_tab, null);
        TextView textViewTab1 = (TextView) view1.findViewById(R.id.learning_title_tabview);
        textViewTab1.setText(titleTablayout[1]);
        tabLayout.getTabAt(1).setCustomView(textViewTab1);
        View view2 = inflater.inflate(R.layout.custom_view_tab, null);
        TextView textViewTab2 = (TextView) view2.findViewById(R.id.learning_title_tabview);
        textViewTab2.setText(titleTablayout[2]);
        tabLayout.getTabAt(2).setCustomView(textViewTab2);
        View view3 = inflater.inflate(R.layout.custom_view_tab, null);
        TextView textViewTab3 = (TextView) view3.findViewById(R.id.learning_title_tabview);
        textViewTab3.setText(titleTablayout[3]);
        tabLayout.getTabAt(3).setCustomView(textViewTab3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 4; i++) {
                    if (tabLayout.getTabAt(i).isSelected()) {
                        TextView textView = (TextView) tabLayout.getTabAt(i).getCustomView();
                        textView.setBackgroundResource(R.drawable.bg_tabview);
                    } else {
                        TextView textView = (TextView) tabLayout.getTabAt(i).getCustomView();
                        textView.setBackground(null);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
