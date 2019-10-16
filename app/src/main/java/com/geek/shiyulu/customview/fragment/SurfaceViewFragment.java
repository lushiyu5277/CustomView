package com.geek.shiyulu.customview.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.shiyulu.customview.R;
import com.geek.shiyulu.customview.canvasview.CountSurfaceView;
import com.geek.shiyulu.customview.canvasview.ZhihuLogoView;


public class SurfaceViewFragment extends BaseFragment {

//    private CountSurfaceView surfaceView;
    private ZhihuLogoView zhihuLogoView;

    @Override
    public String getFragmentName() {
        return "SurfaceViewFragment";
//        HashMap
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_surfaceview, null);
//        surfaceView = rootView.findViewById(R.id.surface_view);
//        surfaceView.setZOrderOnTop(true);
//        surfaceView.setZOrderMediaOverlay(true);
        zhihuLogoView = rootView.findViewById(R.id.zhihu_view);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        zhihuLogoView.startAnimator();
    }

    @Override
    public void onPause() {
        super.onPause();
        zhihuLogoView.stopAnimator();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
