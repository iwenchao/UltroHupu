package com.chaos.ultrohupu.splash.model;

import com.chaos.base.mvp.BaseModel;
import com.chaos.ultrohupu.splash.Constant;
import com.chaos.ultrohupu.splash.contract.SplashContract;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by huangdou
 * on 2017/10/10.
 */

public class SplashModel extends BaseModel implements SplashContract.Model {



    @Inject
    public SplashModel() {
    }

    @Override
    public String getSplashRandomRes() {
        Random random = new Random();
        return Constant.SPLASH_IMG.SPLASH_LIST.get(random.nextInt(Constant.SPLASH_IMG.SPLASH_LIST.size()));
    }
}
