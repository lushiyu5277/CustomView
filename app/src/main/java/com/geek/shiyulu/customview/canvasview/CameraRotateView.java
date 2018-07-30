package com.geek.shiyulu.customview.canvasview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.R;

/**
 * Created by shiyu on 2018/7/29.
 */

public class CameraRotateView extends View {

    private Paint paint;
    private Path path;
    private Camera camera;
    private Bitmap cod4Bitmap;
    private Bitmap cod6Bitmap;
    private ObjectAnimator animator;

    private float degree;

    public CameraRotateView(Context context) {
        super(context);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        camera = new Camera();
        camera.setLocation(0, 0, getResources().getDisplayMetrics().density * -6);
        cod4Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cod4);
        cod6Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cod6);
        path = new Path();
        animator = ObjectAnimator.ofFloat(this, "degree", 360, 0);
        animator.setDuration(5000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制上半部分
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(degree);
        canvas.clipRect(-getWidth() / 2, -getHeight() / 2, getWidth() / 2, 0);
        canvas.rotate(-degree);
        canvas.translate(-getWidth() / 2, -getHeight() / 2);
        canvas.drawBitmap(cod4Bitmap, getWidth() / 2 - cod4Bitmap.getWidth() / 2, getHeight() / 2 - cod4Bitmap.getHeight() / 2, paint);
        canvas.restore();

        //绘制下半部分
//        canvas.save();
//        camera.save();
//        camera.rotateX(30);
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//        canvas.rotate(degree);
//        camera.applyToCanvas(canvas);
//        canvas.rotate(-degree);
//        canvas.translate(-getWidth() / 2, -getHeight() / 2);
//        camera.restore();
////        path.addRect(getWidth() / 2 - cod4Bitmap.getWidth() / 2, getHeight() / 2, getWidth() / 2 + cod4Bitmap.getWidth() / 2, getHeight() / 2 + cod4Bitmap.getWidth() / 2, Path.Direction.CCW);
//        canvas.drawBitmap(cod4Bitmap, getWidth() / 2 - cod4Bitmap.getWidth() / 2, getHeight() / 2 - cod4Bitmap.getHeight() / 2, paint);
//        canvas.restore();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    public float getDegree() {
        return degree;
    }

    public void setDegree(float degree) {
        this.degree = degree;
        invalidate();
    }
}
