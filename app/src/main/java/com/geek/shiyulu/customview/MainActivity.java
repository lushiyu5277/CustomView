package com.geek.shiyulu.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.geek.shiyulu.customview.canvasview.ZhihuLogoView;

public class MainActivity extends AppCompatActivity {

    private ZhihuLogoView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        logoView = findViewById(R.id.zhihuView);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        logoView.startAnimator();
    }
}
