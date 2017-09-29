package com.example.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chaos
 * on 17-7-2.
 */

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

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
    @BindView(R2.id.contentLayout)
    FrameLayout mContentLayout;
    @BindView(R2.id.rootContentView)
    LinearLayout mRootContentView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_container_layout);
        ButterKnife.bind(this);


    }


}
