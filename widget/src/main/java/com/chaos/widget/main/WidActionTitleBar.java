package com.chaos.widget.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.chaos.widget.imp.ViewInterface;

/**
 * Created by huangdou
 * on 2017/9/29.
 */

public class WidActionTitleBar extends View implements ViewInterface {


    public WidActionTitleBar(Context context) {
        this(context, null);
    }

    public WidActionTitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WidActionTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void initView(View view) {

    }

    @Override
    public void initAttr() {

    }
}
