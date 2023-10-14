package com.example.practivejavaandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.practivejavaandroid.adapter.PagerAdapter;
import com.example.practivejavaandroid.R;
import com.example.practivejavaandroid.fragment.CategoryFragment;
import com.example.practivejavaandroid.fragment.DealFragment;
import com.example.practivejavaandroid.fragment.FeatureFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private FeatureFragment featureF;
    private DealFragment dealF;
    private CategoryFragment categoryF;

    private void initView(){
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        featureF = new FeatureFragment();
        dealF = new DealFragment();
        categoryF = new CategoryFragment();

        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(featureF);
        fragments.add(new FeatureFragment());
        fragments.add(new FeatureFragment());

        viewPager.setAdapter(new PagerAdapter(this, fragments));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.feature_fragment_title);
                    break;
                case 1:
                    tab.setText(R.string.deal_fragment_title);
                    break;
                default:
                    tab.setText(R.string.category_fragment_title);
                    break;
            }
        });
        tabLayoutMediator.attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Integer position = tab.getPosition();
                viewPager.setCurrentItem(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
}