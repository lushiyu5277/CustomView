package com.geek.shiyulu.customview.extendview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.geek.shiyulu.customview.utils.UIUtil;

public class MaterialEditText extends android.support.v7.widget.AppCompatEditText {

    private static final int HEADER_OFFSET = (int)UIUtil.dpToPixel(20);

    private CharSequence mFloatingText;

    public MaterialEditText(Context context) {
        super(context);
    }

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mFloatingText = getHint();
        if (mFloatingText != null && mFloatingText.length() > 0) {
            setPadding(getPaddingLeft(), getPaddingTop() + HEADER_OFFSET, getPaddingRight(), getPaddingBottom());
        }
    }

    public MaterialEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
