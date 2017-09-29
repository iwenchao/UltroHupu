package com.example.base.mvp;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> implements IBasePresenter {

    protected M mModel;
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void onDestroy() {

    }
}
