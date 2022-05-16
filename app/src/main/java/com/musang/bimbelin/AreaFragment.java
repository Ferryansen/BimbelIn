package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class AreaFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public AreaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.view_page);

        tabLayout.setupWithViewPager(viewPager);

        vpAdapterAreas vpAdapterArea = new vpAdapterAreas(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapterArea.addFragment(new SquareFragment(), "Square");
        vpAdapterArea.addFragment(new TriangleFragment(), "Triangle");
        vpAdapterArea.addFragment(new CircleFragment(), "Circle");

        viewPager.setAdapter(vpAdapterArea);

        return view;
    }
}