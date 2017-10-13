package com.chaos.base.router;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by huangdou
 * on 2017/10/9.
 */

public class HPRouter {

    public static final int DEFUALT_RESULT_CODE_OK = 1000;

    /**
     * 初始化
     *
     * @param application
     */
    public static void init(Application application) {
        ARouter.init(application);
    }

    /**
     * @param activity
     */
    public static void inject(Activity activity) {
        ARouter.getInstance().inject(activity);
    }

    /**
     * @param fragment
     */

    public static void inject(Fragment fragment) {
        ARouter.getInstance().inject(fragment);
    }

    /**
     * @param path
     */
    public static void navigate(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * @param path
     * @param bundle
     */
    public static void navigate(String path, Bundle bundle) {
        ARouter.getInstance().build(path).with(bundle).navigation();
    }

    /**
     * @param path
     * @param bundle
     * @param flag
     */
    public static void navigate(String path, Bundle bundle, int flag) {
        ARouter.getInstance().build(path).with(bundle).withFlags(flag).navigation();
    }

    /**
     * @param context
     * @param path
     * @param requestCode
     */
    public static void navigateForResult(Activity context, String path, int requestCode) {
        ARouter.getInstance().build(path).navigation(context, requestCode);
    }

    /**
     * @param cActivity
     * @param bundle
     */
    public static void navigateResultBack(Activity cActivity, Bundle bundle) {
        navigateResultBack(cActivity, bundle, DEFUALT_RESULT_CODE_OK);
    }

    /**
     * @param cActivity
     * @param bundle
     * @param resultCode
     */
    public static void navigateResultBack(Activity cActivity, Bundle bundle, Integer resultCode) {
        navigateResultBack(cActivity, bundle, resultCode, null);
    }

    /**
     * @param cActivity
     * @param bundle
     * @param resultCode
     * @param flag
     */
    public static void navigateResultBack(Activity cActivity, Bundle bundle, int resultCode, Integer flag) {
        Intent bIntent = new Intent();
        bIntent.putExtras(bundle);
        if (flag != null) bIntent.addFlags(flag);
        cActivity.setResult(resultCode, bIntent);
        cActivity.finish();
    }

}
