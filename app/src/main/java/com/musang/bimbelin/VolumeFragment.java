package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class VolumeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public VolumeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volume, container, false);

        tabLayout = view.findViewById(R.id.tabLayoutVolume);
        viewPager = view.findViewById(R.id.view_page_volume);

        tabLayout.setupWithViewPager(viewPager);

        vpAdapterVolumes vpAdapterVolume = new vpAdapterVolumes(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapterVolume.addFragment(new BlockFragment(), "Block");
        vpAdapterVolume.addFragment(new PyramidFragment(), "Pyramid");
        vpAdapterVolume.addFragment(new CylinderFragment(), "Cylinder");

        viewPager.setAdapter(vpAdapterVolume);

        return view;
    }
}