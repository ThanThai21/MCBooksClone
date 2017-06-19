package com.esp.mcbooks;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;


public class LearningActivity extends AppCompatActivity{

    private static final String TAG = "LearningActivity";

    Toolbar toolbar;
    ImageView coverImage;
    TabLayout tabLayout;
    ViewPager viewPager;
    String[] titleTablayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        
        init();

        settingViewPager();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 3; i++) {
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

    private void settingViewPager() {
        titleTablayout = new String[] {getString(R.string.general), getString(R.string.study), getString(R.string.task)};
        FragmentManager fragmentManager = getSupportFragmentManager();
        PagerAdapter pagerAdapter = new PagerAdapter(fragmentManager);
        pagerAdapter.add(getResources().getString(R.string.general));
        pagerAdapter.add(getResources().getString(R.string.study));
        pagerAdapter.add(getResources().getString(R.string.task));
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager, false);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
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

    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        coverImage = (ImageView) findViewById(R.id.learing_cover_image_view);
        tabLayout = (TabLayout) findViewById(R.id.learing_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.learing_view_pager);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
