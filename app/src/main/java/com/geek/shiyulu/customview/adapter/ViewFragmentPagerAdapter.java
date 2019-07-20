package com.geek.shiyulu.customview.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.geek.shiyulu.customview.fragment.DashBoardViewFragment;
import com.geek.shiyulu.customview.fragment.FlipViewFragment;
import com.geek.shiyulu.customview.fragment.TagLayoutFragment;

public class ViewFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mNameList;

    public ViewFragmentPagerAdapter(FragmentManager fm, String[] nameList) {
        super(fm);
        this.mNameList = nameList;
    }

    @Override
    public Fragment getItem(int position) {
        switch (mNameList[position]) {
            case "DashBoadView":
                return new DashBoardViewFragment();
            case "FlipView":
                return new FlipViewFragment();
            case "TagLayout":
                return new TagLayoutFragment();
        }
        return new TagLayoutFragment();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mNameList[position];
    }

    @Override
    public int getCount() {
        return mNameList.length;
    }
}
