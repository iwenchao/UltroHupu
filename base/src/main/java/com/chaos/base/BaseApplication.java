package com.chaos.base;

import android.app.Application;

import com.chaos.base.di.HPInjector;
import com.chaos.base.router.HPRouter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public class BaseApplication extends Application {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //
        initLeaker();
        //
        initRouter();
        //
        initDagger2();
    }

    private void initRouter() {
        HPRouter.init(this);
    }

    private void initLeaker() {
        mRefWatcher = LeakCanary.install(this);
    }

    private void initDagger2() {
        HPInjector.init(this, getPackageName());
    }
}
