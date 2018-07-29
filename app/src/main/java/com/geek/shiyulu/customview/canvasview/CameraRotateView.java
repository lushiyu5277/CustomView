package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.R;

/**
 * Created by shiyu on 2018/7/29.
 */

public class CameraRotateView extends View {

    private Paint paint;
    private Bitmap cod4Bitmap;
    private Bitmap cod6Bitmap;

    public CameraRotateView(Context context) {
        super(context);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cod4Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cod4);
        cod6Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cod6);
    }

    public CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(cod4Bitmap, getWidth() / 2 - cod4Bitmap.getWidth() / 2, getHeight() / 2 - cod4Bitmap.getHeight() / 2, paint);
    }
}
