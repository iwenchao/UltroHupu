package com.chaos.base.di;

/**
 * Created by huangdou
 * on 2017/10/13.
 */

public interface IInjector {

    void initComponent();


    void inject(Object target);
}
