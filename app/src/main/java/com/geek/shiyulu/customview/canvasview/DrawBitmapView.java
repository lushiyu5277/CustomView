package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.R;

public class DrawBitmapView extends View{

    private Paint paint;
    private Bitmap bitmap;
    private RectF rectF;

    public DrawBitmapView(Context context) {
        super(context);
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.assassin);
        rectF = new RectF(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2 );
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
