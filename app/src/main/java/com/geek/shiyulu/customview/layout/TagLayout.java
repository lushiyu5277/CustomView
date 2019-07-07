package com.geek.shiyulu.customview.layout;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TagLayout extends ViewGroup {

    List<Rect> childRects = new ArrayList<>();

    public TagLayout(Context context) {
        super(context);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthUsed = 0;
        int heightUsed = 0;
        int lineMaxHeight = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            lineMaxHeight = Math.max(lineMaxHeight, childHeight);
            if (specMode != MeasureSpec.UNSPECIFIED && widthUsed + childWidth > specWidth) {
                widthUsed = 0;
                heightUsed += lineMaxHeight;
                lineMaxHeight = 0;
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
                childWidth = child.getMeasuredWidth();
                childHeight = child.getMeasuredHeight();
            }
            Rect chileRect;
            if (childRects.size() <= i) {
                chileRect = new Rect();
                childRects.add(chileRect);
            } else {
                chileRect = childRects.get(i);
            }
            chileRect.set(widthUsed, heightUsed, widthUsed + childWidth, heightUsed + childHeight);
            widthUsed += childWidth;
        }

        int width = widthUsed;
        int height = heightUsed + lineMaxHeight;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            Rect rect = childRects.get(i);
            getChildAt(i).layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs); //作用是什么？
    }
}
