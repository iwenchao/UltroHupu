package com.chaos.base.di;

/**
 * Created by huangdou
 * on 2017/10/13.
 */

public class BaseInjector implements IInjector {

    static BaseModule sBaseModule;
    static BaseComponent sBaseComponent;

    @Override
    public void initComponent() {

    }

    public BaseModule getModule() {
        if (sBaseModule == null) {
            synchronized (BaseInjector.class) {
                if (sBaseModule == null) {
                    sBaseModule = new BaseModule();
                }
            }
        }
        return null;
    }

    @Override
    public void inject(Object target) {

    }
}
