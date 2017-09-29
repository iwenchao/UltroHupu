package com.example.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

/**
 * Created by chaos
 * on 17-7-2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;

    private ViewGroup mRootContentView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_container_layout);



    }




}
