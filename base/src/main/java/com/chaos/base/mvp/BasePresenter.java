package com.chaos.base.mvp;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> implements IBasePresenter {

    protected M mModel;
    protected V mView;

    public BasePresenter(V v) {
        this.mView = v;
    }

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }

    @Override
    public void onDestroy() {

    }
}
