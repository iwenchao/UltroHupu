package com.chaos.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.chaos.base.imp.OnNetReconnectListener;
import com.chaos.widget.main.WidActionTitleBar;
import com.example.base.R;
import com.example.base.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chaos
 * on 17-7-2.
 */

public abstract class AbstractBaseActivity extends FragmentActivity implements OnNetReconnectListener {


    @BindView(R2.id.contentLayout)
    FrameLayout mContentLayout;
    @BindView(R2.id.rootContentView)
    LinearLayout mRootContentView;
    @BindView(R2.id.actionTitleBar)
    WidActionTitleBar mActionTitleBar;

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_container_layout);
        ButterKnife.bind(this);


    }

    /**
     * 初始化当前页面的布局设置
     *
     * @param view
     */
    protected abstract void initUILay(View view);

    /**
     * 加载初始数据
     */
    protected abstract void loadInitDta();


    @Override
    public void onReconnect(String eventType, List params) {
        //默认不处理
    }
}
