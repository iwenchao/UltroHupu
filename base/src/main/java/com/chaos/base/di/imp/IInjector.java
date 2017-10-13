package com.chaos.base.di.imp;

/**
 * Created by huangdou
 * on 2017/10/13.
 * <p>
 * 实现类需要被反射调用 混淆时避开
 * </p>
 */

public interface IInjector {
    /**
     * 初始化component
     */
    void initComponent();

    /**
     * 为target注入
     *
     * @param target 目标被注入对象
     */
    void inject(Object target);
}
