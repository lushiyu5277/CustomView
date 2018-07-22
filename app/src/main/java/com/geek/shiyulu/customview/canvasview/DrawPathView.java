package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shiyu on 2018/7/22.
 */

public class DrawPathView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    RectF rectF = new RectF(50, 50, 250, 150);

    public DrawPathView(Context context) {
        super(context);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.addOval(rectF, Path.Direction.CW);
        RectF pathRectF = new RectF(250, 50, 350, 150);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path.addArc(pathRectF, 0, 60);
        canvas.drawPath(path, paint);
    }
}
