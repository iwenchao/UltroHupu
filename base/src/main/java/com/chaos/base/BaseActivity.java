package com.example.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.chaos.widget.main.WidActionTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chaos
 * on 17-7-2.
 */

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    @BindView(R2.id.contentLayout)
    FrameLayout mContentLayout;
    @BindView(R2.id.rootContentView)
    LinearLayout mRootContentView;
    @BindView(R2.id.actionTitleBar)
    WidActionTitleBar mActionTitleBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_container_layout);
        ButterKnife.bind(this);


    }


}
