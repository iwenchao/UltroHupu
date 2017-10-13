package com.chaos.ultrohupu.di;

import com.chaos.base.di.HupuModule;
import com.chaos.ultrohupu.splash.ui.SplashActivity;

import dagger.Component;

/**
 * Created by huangdou
 * on 2017/10/13.
 */

@Component(modules = HupuModule.class)
public interface AppComponent {

    void inject(SplashActivity splashActivity);
}
