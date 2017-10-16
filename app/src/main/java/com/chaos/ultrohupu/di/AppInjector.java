package com.chaos.ultrohupu.di;

import com.chaos.base.di.imp.IInjector;
import com.chaos.base.utils.LogUtils;
import com.chaos.ultrohupu.HomeActivity;
import com.chaos.ultrohupu.splash.ui.SplashActivity;

/**
 * Created by huangdou
 * on 2017/10/13.
 * 该类需要被反射调用 混淆时避开该类
 */

public class AppInjector implements IInjector {

    static AppComponent sAppComponent;
    @Override
    public void initComponent() {
        sAppComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();

    }

    @Override
    public void inject(Object target) {
        LogUtils.i("start App injector");
        if (target instanceof SplashActivity) {
            sAppComponent.inject((SplashActivity) target);
        } else if (target instanceof HomeActivity) {
            sAppComponent.inject((HomeActivity) target);
        }
    }
}
