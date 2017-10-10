package com.chaos.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    @BindView(R2.id.rootContentView)
    LinearLayout mRootContentView;
    @BindView(R2.id.contentLayout)
    FrameLayout mContentLayout;
    @BindView(R2.id.actionTitleBar)
    WidActionTitleBar mActionTitleBar;
    @BindView(R2.id.emptyLayout)
    FrameLayout mEmptyLayout;

    protected Context mContext;

    protected ViewGroup mContentView;
    protected int contentLayoutId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_container_layout);
        inflateContentUi();
        ButterKnife.bind(this);

        initUILay(mContentLayout);
        loadInitDta();
    }

    private void inflateContentUi() {
        contentLayoutId = getContentLayoutId();
        mContentView = (ViewGroup) LayoutInflater.from(this).inflate(contentLayoutId, mContentLayout, true);
    }

    /**
     * 获得当前页面的布局
     *
     * @return
     */
    public abstract int getContentLayoutId();

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


    /**
     * @param title
     */
    protected void setTitleBar(String title) {
        mActionTitleBar.setTitleBar(title);
    }

    /**
     * @param title
     * @param titleIcon
     */
    public void setTitleBar(String title, Integer titleIcon) {
        mActionTitleBar.setTitleBar(title, titleIcon);
    }

    /**
     * @param title
     * @param titleIcon
     * @param leftListener
     */
    public void setTitleBarLeft(String title, Integer titleIcon, View.OnClickListener leftListener) {
        mActionTitleBar.setTitleBarLeft(title, titleIcon, leftListener);
    }

    /**
     * @param titleId
     * @param titleIcon
     * @param leftListener
     */
    public void setTitleBarLeft(int titleId, Integer titleIcon, View.OnClickListener leftListener) {
        mActionTitleBar.setTitleBarLeft(titleId, titleIcon, leftListener);
    }

    /**
     * @param title
     * @param titleIcon
     * @param rightListener
     */
    public void setTitleBarRight(String title, Integer titleIcon, View.OnClickListener rightListener) {
        mActionTitleBar.setTitleBarRight(title, titleIcon, rightListener);
    }

    /**
     * @param titleId
     * @param titleIcon
     * @param rightListener
     */
    public void setTitleBarRight(int titleId, Integer titleIcon, View.OnClickListener rightListener) {
        mActionTitleBar.setTitleBarRight(titleId, titleIcon, rightListener);
    }

    /**
     * @param leftListener
     */
    public void setTitleLeftListener(View.OnClickListener leftListener) {
        mActionTitleBar.setOnClickListener(leftListener);
    }

    /**
     * @param rightListener
     */
    public void setTitleRightListener(View.OnClickListener rightListener) {
        mActionTitleBar.setOnClickListener(rightListener);
    }

    /**
     * @param eventType
     * @param params
     */
    @Override
    public void onReconnect(String eventType, List params) {
        //默认不处理
    }
}
