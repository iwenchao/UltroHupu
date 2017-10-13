package com.chaos.base.di;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangdou
 * on 2017/10/13.
 */

public class HPInjector {

    private static final String APP_PACKAGE = "com.chaos.ultrohupu";
    private static final String APP_INJECTOR = "com.chaos.ultrohupu.di.AppInjector";
    private static final String BASE_INJECTOR = "com.chaos.base.di.BaseInjector";

    private static List<String> mInjectClazzList = new ArrayList<>();
    private static Class<?> mInjector = null;


    static {
        mInjectClazzList.add(APP_INJECTOR);
        mInjectClazzList.add(BASE_INJECTOR);
    }

    /**
     * @param clazzName
     */
    static void init(String clazzName) {
        try {
            mInjector = Class.forName(clazzName);
            mInjector.newInstance();
            mInjector.getDeclaredMethod("initComponent").setAccessible(true);
            mInjector.getMethod("initComponent").invoke(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在应用初始化的时候，调用
     *
     * @param target
     * @param packageName
     */
    public static void init(Object target, String packageName) {
        if (APP_PACKAGE.equals(packageName)) {
            for (int i = 0; i < mInjectClazzList.size(); i++) {
                init(mInjectClazzList.get(i));
                inject(target);
            }
        }

    }

    /**
     * @param target
     */
    public static void inject(Object target) {
        try {
            mInjector.getDeclaredMethod("inject", Object.class).setAccessible(true);
            mInjector.getMethod("inject", Object.class).invoke(null, target);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
