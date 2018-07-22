package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shiyu on 2018/7/22.
 */

public class PercentView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF = new RectF(50, 50, 250, 250);

    public PercentView(Context context) {
        super(context);
    }

    public PercentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.parseColor("#368FFF"));
        rectF.offset((float) (10 * Math.cos(Math.PI / 6)), (float) (10 * Math.sin(Math.PI / 6)));
        canvas.drawArc(rectF, 0, 60, true, paint);
        rectF.offset((float) (-10 * Math.cos(Math.PI / 6)), (float) (-10 * Math.sin(Math.PI / 6)));
        paint.setColor(Color.parseColor("#FF3AC9"));
        canvas.drawArc(rectF, 60, 120, true, paint);
        paint.setColor(Color.parseColor("#FFF33A"));
        canvas.drawArc(rectF, 180, 70, true, paint);
        paint.setColor(Color.parseColor("#4CFF42"));
        canvas.drawArc(rectF, 250, 110, true, paint);

    }
}
