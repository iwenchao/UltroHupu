package com.chaos.ultrohupu.splash;

import com.chaos.base.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by huangdou
 * on 2017/10/10.
 */

public class SplashPresenter extends BasePresenter<SplashConstract.Model, SplashConstract.View> implements SplashConstract.Presenter {

    @Inject
    public SplashPresenter(SplashConstract.View view) {
        super(view);
    }

    @Inject
    public SplashPresenter(SplashConstract.Model model, SplashConstract.View view) {
        super(model, view);
    }

    @Override
    public void fetchSplashRes() {

    }
}
