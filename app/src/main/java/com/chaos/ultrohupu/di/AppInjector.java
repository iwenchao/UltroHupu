package com.chaos.ultrohupu.di;

import com.chaos.base.di.IInjector;

/**
 * Created by huangdou
 * on 2017/10/13.
 * 该类需要被反射调用 混淆时避开该类
 */

public class AppInjector implements IInjector {
    static AppComponent sAppComponent;
    static AppModule sAppModule;

    @Override
    public void initComponent() {


    }

    @Override
    public void inject(Object target) {

    }
}