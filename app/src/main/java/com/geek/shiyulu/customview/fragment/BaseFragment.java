package com.geek.shiyulu.customview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    public abstract String getFragmentName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getFragmentName(), "OnCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(getFragmentName(), "onCreateView");
        return null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(getFragmentName(), "onAttatch Activity");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.i(getFragmentName(), "onAttachFragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(getFragmentName(), "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(getFragmentName(), "onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(getFragmentName(), "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(getFragmentName(), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(getFragmentName(), "onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(getFragmentName(), "onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(getFragmentName(), "onDestroy");
    }


}
