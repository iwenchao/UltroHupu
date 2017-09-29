package com.chaos.widget.main;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chaos.widget.R;
import com.chaos.widget.R2;
import com.chaos.widget.imp.ViewInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huangdou
 * on 2017/9/29.
 */

public class WidActionTitleBar extends View implements ViewInterface {

    @BindView(R2.id.titleBarLeftIcon)
    ImageView mTitleBarLeftIcon;
    @BindView(R2.id.titleBarNameIcon)
    ImageView mTitleBarNameIcon;
    @BindView(R2.id.titleBarNameTxt)
    TextView mTitleBarNameTxt;
    @BindView(R2.id.titleBarNameFL)
    FrameLayout mTitleBarNameFL;
    @BindView(R2.id.titleBarRightTxt)
    TextView mTitleBarRightTxt;
    @BindView(R2.id.titleBarRightIcon)
    ImageView mTitleBarRightIcon;
    @BindView(R2.id.titleBarRight)
    LinearLayout mTitleBarRight;
    @BindView(R2.id.appTitleBar)
    RelativeLayout mAppTitleBar;
    private Context mContext;
    private View mContainer;

    public WidActionTitleBar(Context context) {
        this(context, null);
    }

    public WidActionTitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WidActionTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = getContext();
        initAttr(attrs);
        initView();
    }


    @Override
    public void initAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.WidActionTitleBar);

        ta.recycle();
    }

    @Override
    public void initView() {
        mContainer = LayoutInflater.from(mContext).inflate(R.layout.action_title_bar_layout, null);
        ButterKnife.bind(mContainer);
    }
}
