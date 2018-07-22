package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawArcView extends View {

    public DrawArcView(Context context) {
        super(context);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        RectF rectFLeft = new RectF(100,100, 300, 300 );
        RectF rectFRight = new RectF(400, 100, 800, 300);
        canvas.drawArc(rectFLeft, 0, 60, true, paint);
        canvas.drawArc(rectFLeft, 0, -120, false, paint);

        canvas.drawArc(rectFRight, -60, 60, true, paint);
        canvas.drawArc(rectFRight, 0, 60, false, paint);
//        canvas.drawArc(100, 100, 300, 300, 0, 60, true, paint);
//        canvas.drawArc(100, 100, 300, 300, 70, 60, false, paint);
//
//        canvas.drawArc(400, 100, 800, 300, 0, 60, true, paint);
//        canvas.drawArc(400, 100, 800, 300, 70, 60, false, paint);
    }
}
