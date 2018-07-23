package com.geek.shiyulu.customview.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by shiyu on 2018/7/23.
 */

public class UIUtil {

    public static float dpToPixel(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }
}
