package com.geek.shiyulu.customview.extendview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.geek.shiyulu.customview.utils.UIUtil;

public class MaterialEditText extends android.support.v7.widget.AppCompatEditText {

    private static final int LABEL_SIZE = (int) UIUtil.dpToPixel(12);
    private static final int LABEL_PADDING = (int) UIUtil.dpToPixel(12);

    private CharSequence mFloatingText;
    private boolean usingFloatText = true;
    private boolean isEmpty = true;
    private float floatingTextFraction = 0f;
    private float floatingTranslationFraction = 1f;
    private float textSize;

    private Paint paint;
    private ObjectAnimator alphaAnimator;
    private ObjectAnimator translationAnimator;

    public MaterialEditText(Context context) {
        super(context);
    }

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mFloatingText = getHint();
        if (usingFloatText) {
            setPadding(getPaddingLeft(), getPaddingTop() + LABEL_PADDING + LABEL_SIZE, getPaddingRight(), getPaddingBottom());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(LABEL_SIZE);
        textSize = getTextSize();
        initTextWatcher();
    }

    public MaterialEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initTextWatcher() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 ) {
                    if (isEmpty) {
                        isEmpty = false;
                        if (alphaAnimator == null) {
                            alphaAnimator = ObjectAnimator.ofFloat(MaterialEditText.this, "floatingTextFraction", 0f, 1f).setDuration(1000);
                        }
                        if (translationAnimator == null) {
                            translationAnimator = ObjectAnimator.ofFloat(MaterialEditText.this, "floatingTranslationFraction", 1f, 0f).setDuration(1000);
                        }
                        alphaAnimator.start();
                        translationAnimator.start();
                    }
                } else {
                    isEmpty = true;
                    translationAnimator.reverse();
                    alphaAnimator.reverse();
                }
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAlpha((int) (255 * floatingTextFraction));
        if (usingFloatText && mFloatingText != null) {
            canvas.drawText(mFloatingText, 0, mFloatingText.length(), getPaddingLeft(), LABEL_SIZE + LABEL_PADDING + floatingTranslationFraction * textSize, paint);
        }
    }

    public float getFloatingTextFraction() {
        return floatingTextFraction;
    }

    public void setFloatingTextFraction(float floatingTextFraction) {
        this.floatingTextFraction = floatingTextFraction;
        invalidate();
    }

    public float getFloatingTranslationFraction() {
        return floatingTranslationFraction;
    }

    public void setFloatingTranslationFraction(float floatingTranslationFraction) {
        this.floatingTranslationFraction = floatingTranslationFraction;
        invalidate();
    }
}
