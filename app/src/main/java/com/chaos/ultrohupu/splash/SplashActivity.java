package com.chaos.ultrohupu.splash;

import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chaos.base.AbstractBaseActivity;
import com.chaos.ultrohupu.R;
import com.chaos.ultrohupu.constant.RouterPath;

import butterknife.BindView;

/**
 * Created by huangdou
 * on 2017/10/9.
 * 启动页：启动三秒后，进入home
 */
@Route(path = RouterPath.SPLASH_ACTIVITY)
public class SplashActivity extends AbstractBaseActivity implements SplashConstract.View {


    @BindView(R.id.splashAdImg)
    ImageView mSplashAdImg;
    @BindView(R.id.splashLogo)
    ImageView mSplashLogo;


    @Override
    public int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initUILay(View view) {

    }

    @Override
    protected void loadInitDta() {

    }

}
