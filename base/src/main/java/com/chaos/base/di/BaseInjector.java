package com.chaos.base.di;

import com.chaos.base.BaseApplication;
import com.chaos.base.di.imp.IInjector;

/**
 * Created by huangdou
 * on 2017/10/13.
 */

public class BaseInjector implements IInjector {

    static BaseComponent sBaseComponent;

    @Override
    public void initComponent() {
        sBaseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
    }



    @Override
    public void inject(Object target) {
        if (target instanceof BaseApplication) {
            sBaseComponent.inject((BaseApplication) target);
        }/*else if(){

        }*/
    }
}
