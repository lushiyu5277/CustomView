package com.geek.shiyulu.customview.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

/**
 * Created by shiyu on 2018/7/23.
 */

public class UIUtil {

    public static float dpToPixel(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }

    public static Bitmap getDrawableBitmap(Resources resources, int id, int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, id, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(resources, id, options);
    }

    public static Bitmap getFullViewBitmap(Resources resources, int id, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, id, options);
        options.inJustDecodeBounds = false;
        float scale = (float)options.outWidth / options.outHeight;
        if (scale < 1) {
            options.inDensity = options.outHeight;
            options.inTargetDensity = height;
        } else {
            options.inDensity = options.outWidth;
            options.inTargetDensity = width;
        }
        return BitmapFactory.decodeResource(resources, id, options);
    }
}
