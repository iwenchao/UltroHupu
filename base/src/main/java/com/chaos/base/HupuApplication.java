package com.chaos.base;

import android.app.Application;

import com.chaos.base.router.HPRouter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public class HupuApplication extends Application {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //
        initLeaker();
        //
        initRouter();
    }

    private void initRouter() {
        HPRouter.init(this);
    }

    private void initLeaker() {
        mRefWatcher = LeakCanary.install(this);
    }
}
