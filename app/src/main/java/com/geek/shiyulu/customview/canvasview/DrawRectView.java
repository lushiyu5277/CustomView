package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawRectView extends View {

    public DrawRectView(Context context) {
        super(context);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Rect rect = new Rect(100, 100, 200, 200);
        canvas.drawRect(rect, paint);
    }
}
