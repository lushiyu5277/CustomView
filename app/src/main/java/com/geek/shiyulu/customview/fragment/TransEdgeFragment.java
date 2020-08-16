package com.geek.shiyulu.customview.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.shiyulu.customview.R;

public class TransEdgeFragment extends BaseFragment{
    @Override
    public String getFragmentName() {
        return "TransEdgeFragment";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_trans_edge_layout, null);
    }
}
