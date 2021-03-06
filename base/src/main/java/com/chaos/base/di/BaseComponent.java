package com.chaos.base.di;

import com.chaos.base.BaseApplication;

import dagger.Subcomponent;

/**
 * Created by huangdou
 * on 2017/10/9.
 * 该类为全局对象的依赖注入
 */
@Subcomponent(modules = BaseModule.class)
public interface BaseComponent {

    void inject(BaseApplication baseApplication);

}
