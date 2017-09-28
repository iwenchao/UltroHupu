package com.example.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by chaos
 * on 17-7-2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());



    }

    protected View getContentView(){
        return LayoutInflater.from(this).inflate(setLayoutId(),null);
    }


    public abstract int setLayoutId();




    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    protected void navigate(){

    }

    protected void navigateWithResult(){

    }




}
