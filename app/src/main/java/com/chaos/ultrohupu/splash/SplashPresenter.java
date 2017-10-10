package com.chaos.ultrohupu.splash;

import com.chaos.base.mvp.BasePresenter;

/**
 * Created by huangdou
 * on 2017/10/10.
 */

public class SplashPresenter extends BasePresenter<SplashConstract.Model, SplashConstract.View> implements SplashConstract.Presenter {


    public SplashPresenter(SplashConstract.View view) {
        super(view);
    }

    public SplashPresenter(SplashConstract.Model model, SplashConstract.View view) {
        super(model, view);
    }
}
