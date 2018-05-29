package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawCircleView extends View {

    public DrawCircleView(Context context) {
        super(context);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawCircle(200, 200, 150, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(550, 200, 150, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(900, 200, 135, paint);
    }
}
