package com.geek.shiyulu.customview.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.shiyulu.customview.R;

public class TagLayoutFragment extends BaseFragment {
    @Override
    public String getFragmentName() {
        return "TagLayoutFragment";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_taglayout, null);
        Log.i(getFragmentName(), "rootView has " + countView(rootView) + " views");
        return rootView;
    }
}
