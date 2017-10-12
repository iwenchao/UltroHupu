package com.chaos.widget.main;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by huangdou
 * on 2017/10/12.
 *
 * @Description 控件实现了引导页的倒计时
 */

public class WidJumpView extends android.support.v7.widget.AppCompatTextView {

    private int mOutLineColor = 0xFF888888;
    private int mOutLineWidth = 4;//px

    private int mCircleColor = 0x99888888;
    private int mCircleRadius;

    private int mTextColor = Color.WHITE;

    private int mProgressLineColor = Color.RED;
    private int mProgressLineWidth = 4;//px
    private int mProgress = 0;

    private int mCenterX, mCenterY;

    private int mDuration = 2000;//ms


    public WidJumpView(Context context) {
        super(context);
    }

    public WidJumpView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WidJumpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
