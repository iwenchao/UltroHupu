package com.chaos.ultrohupu.splash.presenter;

import com.chaos.base.mvp.BasePresenter;
import com.chaos.ultrohupu.splash.contract.SplashContract;
import com.chaos.ultrohupu.splash.model.SplashModel;

import javax.inject.Inject;

/**
 * Created by huangdou
 * on 2017/10/10.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Inject
    SplashModel mModel;


    @Inject
    public SplashPresenter(SplashContract.View view) {
        super(view);
    }


    @Override
    public void fetchSplashRes() {
        String imageUrl = mModel.getSplashRandomRes();
        mView.updateContent(imageUrl);
    }
}
