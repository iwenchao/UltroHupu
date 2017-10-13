package com.chaos.base.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huangdou
 * on 2017/10/9.
 * 该类为全局对象的依赖注入
 */
@Singleton
@Component(modules = {
        BaseModule.class
})
public interface BaseComponent {


}
