package com.geek.shiyulu.customview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.geek.shiyulu.customview.adapter.ViewFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    String[] tabTitle = {"TransEdgeFragment","DashBoardView", "FlipView", "TagLayout" };
    ViewPager mViewPager;
    PagerTabStrip mPagerTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.view_pager);
        mPagerTabStrip = findViewById(R.id.pager_tab_strip);
        mViewPager.setAdapter(new ViewFragmentPagerAdapter(getSupportFragmentManager(),tabTitle));
//        mViewPager.setOnPageChangeListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
