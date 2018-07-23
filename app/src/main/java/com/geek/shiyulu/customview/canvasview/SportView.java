package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.utils.UIUtil;

/**
 * Created by shiyu on 2018/7/23.
 */

public class SportView extends View {

    final private static float RADIUS = UIUtil.dpToPixel(150);

    private RectF rectF = new RectF();
    private Paint paint = new Paint();

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
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(UIUtil.dpToPixel(10));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, RADIUS, paint);
        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(rectF, -120, 300, false, paint);
        String drawText = "SPort";
        paint.setTextSize(UIUtil.dpToPixel(70));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Rect bounds = new Rect();
        paint.getTextBounds(drawText, 0, drawText.length(), bounds);
        canvas.drawText(drawText, getWidth() / 2, getHeight() / 2 + (bounds.bottom - bounds.top) / 2, paint);
    }
}
