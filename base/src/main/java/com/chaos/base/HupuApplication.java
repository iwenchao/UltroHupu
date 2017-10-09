package com.chaos.base;

import android.app.Application;

import com.chaos.base.router.HPRouter;

/**
 * Created by chaos
 * On 17-7-2.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public class HupuApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        initRouter();
    }

    private void initRouter() {
        HPRouter.init(this);
    }
}
