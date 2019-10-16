package com.geek.shiyulu.customview.canvasview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.utils.UIUtil;

/**
 * Created by shiyu on 2018/7/29.
 */

public class ZhihuLogoView extends View {

    private static final float RADIUS = UIUtil.dpToPixel(40);

    private Paint paint;

    private RectF rectF;
    private float angle;
    private ObjectAnimator animator;

    public ZhihuLogoView(Context context) {
        super(context);
    }

    public ZhihuLogoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        animator = ObjectAnimator.ofFloat(this, "angle", 0f, 285f);
        animator.setDuration(1000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(UIUtil.dpToPixel(10));
        paint.setStrokeCap(Paint.Cap.ROUND);
        rectF = new RectF();
    }

    public ZhihuLogoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
        canvas.drawArc(rectF, 90f, angle, false, paint);
    }

    public void startAnimator() {
        animator.start();
    }

    public void stopAnimator() {
        animator.cancel();
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
        invalidate();
    }
}
