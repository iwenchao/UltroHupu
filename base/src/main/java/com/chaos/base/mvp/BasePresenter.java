package com.chaos.base.mvp;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected V mView;

    public BasePresenter(V v) {
        this.mView = v;
    }


    @Override
    public void onDestroy() {

    }
}
