package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.R;

public class FlipView extends View {

    private Paint paint;
    private Path circlePath;
    private Bitmap cod4Bitmap;
    private Bitmap cod6Bitmap;

    public FlipView(Context context) {
        super(context);
    }

    public FlipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cod4Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cod4);
        cod6Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cod6);
        circlePath = new Path();
    }

    public FlipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circlePath.reset();
        canvas.save();
        canvas.translate(-(getWidth() / 2 - cod4Bitmap.getWidth() / 2), -(getHeight() / 2 - cod4Bitmap.getHeight() / 2));
        circlePath.addCircle(getWidth() / 2, getHeight() / 2, cod4Bitmap.getWidth() / 2, Path.Direction.CCW);
        canvas.clipPath(circlePath);
        canvas.drawBitmap(cod4Bitmap, getWidth() / 2 - cod4Bitmap.getWidth() / 2, getHeight() / 2 - cod4Bitmap.getHeight() / 2, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(-(getWidth() / 2 - cod6Bitmap.getWidth() ), (getHeight() / 2 - cod6Bitmap.getHeight() ));
        canvas.scale(2,2, getWidth() / 2, getHeight() / 2);
        canvas.clipPath(circlePath);
        canvas.drawBitmap(cod6Bitmap, getWidth() / 2 - cod6Bitmap.getWidth() / 2, getHeight() / 2 - cod6Bitmap.getHeight() / 2, paint);
        canvas.restore();

        canvas.save();
//        canvas.clipPath(circlePath);
//        canvas.rotate(45, getWidth() / 2, getHeight() / 2);
        canvas.skew(-0.5f, 0f);
        canvas.drawBitmap(cod6Bitmap, getWidth() / 2 - cod6Bitmap.getWidth() / 2, getHeight() / 2 - cod6Bitmap.getHeight() / 2, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(getWidth() / 2 - cod6Bitmap.getWidth() / 2, getHeight() / 2 - cod6Bitmap.getHeight() / 2);
        canvas.clipPath(circlePath);
        canvas.rotate(45, getWidth() / 2, getHeight() / 2);
        canvas.drawBitmap(cod6Bitmap, getWidth() / 2 - cod6Bitmap.getWidth() / 2, getHeight() / 2 - cod6Bitmap.getHeight() / 2, paint);
        canvas.restore();

        //TODO understand skew and use matrix for view


    }
}
