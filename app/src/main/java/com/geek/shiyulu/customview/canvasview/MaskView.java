package com.geek.shiyulu.customview.canvasview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.geek.shiyulu.customview.R;
import com.geek.shiyulu.customview.utils.UIUtil;

import static android.graphics.Canvas.ALL_SAVE_FLAG;

/**
 * Created by shiyulu on 2018/7/25.
 */

public class MaskView extends View {

    private static final int WIDTH = (int) UIUtil.dpToPixel(320);
    private static final int HEIGHT = (int) UIUtil.dpToPixel(180);

    private Paint paint;
    Bitmap bitmap;
    RectF rectF;
    Xfermode xfermodeSrcIn = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    Xfermode xfermodeDstIn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    public MaskView(Context context) {
        super(context);
    }

    public MaskView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.assassin);
        rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public MaskView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saved = canvas.saveLayer(null, paint, ALL_SAVE_FLAG);
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, HEIGHT / 2, paint);
//        paint.setXfermode(xfermodeSrcIn);
//        canvas.drawBitmap(bitmap, getWidth() / 2 - HEIGHT / 2, getHeight() / 2 - HEIGHT / 2, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(rectF.right, rectF.bottom, HEIGHT / 2, paint);
        paint.setXfermode(xfermodeSrcIn);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rectF, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);
        paint.setColor(Color.BLACK);
    }
}
