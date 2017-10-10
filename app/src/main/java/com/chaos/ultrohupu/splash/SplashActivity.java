package com.chaos.ultrohupu.splash;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chaos.base.AbstractBaseActivity;
import com.chaos.ultrohupu.constant.RouterPath;

/**
 * Created by huangdou
 * on 2017/10/9.
 * 启动页：启动三秒后，进入home
 */
@Route(path = RouterPath.SPLASH_ACTIVITY)
public class SplashActivity extends AbstractBaseActivity implements SplashConstract.View {


    @Override
    protected void initUILay(View view) {

    }

    @Override
    protected void loadInitDta() {

    }
}
