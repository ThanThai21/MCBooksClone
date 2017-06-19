package com.esp.mcbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Admin on 30/5/2017.
 */

public class LearningOverviewFragment extends Fragment {

    Button detailButton;
    Button addScheduleButton;
    Button countinueButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_overview, container, false);
        mapping(view);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BookDetailActivity.class);
                startActivity(intent);
            }
        });

        addScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddScheduleActivity.class);
                startActivity(intent);
            }
        });

        countinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.learing_view_pager);
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }

    public void mapping(View view) {
        detailButton = (Button) view.findViewById(R.id.overview_detail_button);
        addScheduleButton = (Button) view.findViewById(R.id.overview_add_schedule_button);
        countinueButton = (Button) view.findViewById(R.id.overview_countinue_button);
    }
}
