package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shiyu on 2018/7/22.
 */

public class DashBoadView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path dash = new Path();
    private PathMeasure pathMeasure = new PathMeasure();

    public DashBoadView(Context context) {
        super(context);
    }

    public DashBoadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DashBoadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(getWidth() / 2 - 300, getHeight() / 2 - 300, getWidth() / 2 + 300, getHeight() / 2 + 300);
        RectF dashRectF = new RectF(0,0,3,20);
        dash.addRect(dashRectF, Path.Direction.CCW);
        PathEffect pathEffect = new PathDashPathEffect(dash, 50, 60, PathDashPathEffect.Style.ROTATE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setPathEffect(pathEffect);
        canvas.drawArc(rectF, 150, 240, false, paint);
//        canvas.drawPath(path, paint);
        paint.setPathEffect(null);
        canvas.drawArc(rectF, 150, 240, false, paint);
    }
}
