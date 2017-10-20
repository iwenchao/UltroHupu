package com.chaos.ultrohupu.splash.ui;

import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.chaos.base.AbstractBaseActivity;
import com.chaos.ultrohupu.R;
import com.chaos.ultrohupu.constant.RouterPath;
import com.chaos.ultrohupu.splash.contract.SplashContract;
import com.chaos.ultrohupu.splash.model.SplashModel;
import com.chaos.ultrohupu.splash.presenter.SplashPresenter;
import com.chaos.widget.main.WidJumpView;

import butterknife.BindView;

/**
 * Created by huangdou
 * on 2017/10/9.
 * 启动页：启动三秒后，进入home
 */

@Route(path = RouterPath.SPLASH_ACTIVITY)
public class SplashActivity extends AbstractBaseActivity implements SplashContract.View {


    @BindView(R.id.splashAdImg)
    ImageView mSplashAdImg;
    @BindView(R.id.splashLogo)
    ImageView mSplashLogo;
    @BindView(R.id.splashJump)
    WidJumpView mSplashJump;

    SplashModel mModel = new SplashModel();

    SplashContract.Presenter mPresenter;


    @Override
    public int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initThings(View view) {
        mPresenter = new SplashPresenter(mModel, this);
    }


    @Override
    protected void loadInitDta() {
        mPresenter.fetchSplashRes();
    }

    @Override
    public void updateContent(String imageUrl) {
        Glide.with(this).load(imageUrl).into(mSplashAdImg);
    }
}
