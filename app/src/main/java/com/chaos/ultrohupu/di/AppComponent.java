package com.chaos.ultrohupu.di;

import com.chaos.base.di.BaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huangdou
 * on 2017/10/13.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        BaseModule.class,
})
public interface AppComponent {


}
