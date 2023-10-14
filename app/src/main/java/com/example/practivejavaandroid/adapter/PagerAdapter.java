package com.example.practivejavaandroid.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.practivejavaandroid.activity.MainActivity;

import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragments;

    public PagerAdapter(MainActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }
}
