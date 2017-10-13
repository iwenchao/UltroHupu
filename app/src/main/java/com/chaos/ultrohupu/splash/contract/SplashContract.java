package com.chaos.ultrohupu.splash.contract;

import com.chaos.base.mvp.IBaseModel;
import com.chaos.base.mvp.IBasePresenter;
import com.chaos.base.mvp.IBaseView;

/**
 * Created by huangdou
 * on 2017/10/9.
 */

public interface SplashContract {


    /**
     *
     */
    interface Model extends IBaseModel {

        String getSplashRandomRes();

    }

    /**
     *
     */
    interface View extends IBaseView {

        void updateContent(String imageUrl);

    }

    /**
     *
     */
    interface Presenter extends IBasePresenter {

        void fetchSplashRes();

    }
}
