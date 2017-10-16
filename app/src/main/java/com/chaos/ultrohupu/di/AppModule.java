package com.chaos.ultrohupu.di;

import com.chaos.base.utils.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangdou
 * on 2017/10/13.
 */
@Module()
public class AppModule {


    @Singleton
    @Provides
    JsonUtils provideJsonUtils(ObjectMapper objectMapper) {
        return new JsonUtils(objectMapper);
    }

    @Singleton
    @Provides
    ObjectMapper provideObjectMapper() {
        return new ObjectMapper();
    }



}
