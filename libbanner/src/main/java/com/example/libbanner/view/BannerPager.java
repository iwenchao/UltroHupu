package com.example.libbanner.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by chaos
 * On 17-7-4.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public class BannerPager extends ViewPager {
    private boolean scrollable = true;

    public BannerPager(Context context) {
        super(context);
    }

    public BannerPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isScrollable() {
        return scrollable;
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScrollable() && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScrollable() && super.onTouchEvent(ev);
    }
}
