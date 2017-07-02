package com.example.base.mvp;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public abstract  class BasePresenterImp<M extends BaseModel , V extends BaseView> implements BasePresenter{

    protected M mModel;
    protected V mView;

    public BasePresenterImp(V mView) {
        this.mView = mView;
    }

    public BasePresenterImp(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }



}
