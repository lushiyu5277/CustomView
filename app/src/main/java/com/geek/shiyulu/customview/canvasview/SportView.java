package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.utils.UIUtil;

/**
 * Created by shiyu on 2018/7/23.
 */

public class SportView extends View {

    final private static float RADIUS = UIUtil.dpToPixel(100);

    private RectF rectF = new RectF();

    public SportView(Context context) {
        super(context);
    }

    public SportView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SportView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
        
    }
}
