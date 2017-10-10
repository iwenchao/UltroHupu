package com.chaos.ultrohupu.splash;

import com.chaos.base.mvp.IBaseModel;
import com.chaos.base.mvp.IBasePresenter;
import com.chaos.base.mvp.IBaseView;

/**
 * Created by huangdou
 * on 2017/10/9.
 */

public interface SplashConstract {


    /**
     *
     */
    interface Model extends IBaseModel {

        int getSplashRandomRes();

    }

    /**
     *
     */
    interface View extends IBaseView {

        void updateContent();

    }

    /**
     *
     */
    interface Presenter extends IBasePresenter {

        void fetchSplashRes();

    }
}
