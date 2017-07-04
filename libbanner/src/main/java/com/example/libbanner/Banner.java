package com.example.libbanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.libbanner.loader.Imageable;
import com.example.libbanner.utils.Config;
import com.example.libbanner.view.BannerPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaos
 * On 17-7-4.
 * Email:iwenchaos@gmail.com
 * Description: 图片轮播组件
 */

public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener{
    public static final String TAG = Banner.class.getSimpleName();

    private Context context;
    /*view page configuration*/
    private int indicMargin = Config.Banner.MARGIN;
    private int indicWidth;
    private int indicHeight;
    private int indicSize;
    private int indicStyle = Config.Indicator.Style.CIRCLE_INDICATOR.getValue();
    private int delayTime = Config.Banner.DELAY_TIME;
    private int scrollDuration = Config.Banner.DURATION;
    private boolean autoPlay = Config.Banner.AUTO_PLAY;
    private boolean canScroll = Config.Banner.CAN_SCROLL;
    private int indicSelectedResId;
    private int indicUnselectResId;
    private int layoutResId;
    private int indicGravity;
    private int scaleType;

    private int titleHeight;
    private int titleBackground;
    private int titleTxtColor;
    private int titleTxtSize;

    private int pageSize;
    private int currentPage;
    private int lastPage;

    /*data*/
    private List<String> titles;
    private List<String> pageUrls;
    private List<View> pageViews;
    private List<ImageView> pageIndics;
    private BannerPager bannerPager;
    private TextView banTitleTv,numIndicInsideTv,numIndicTv;
    private LinearLayout indicatorLL,indicatorInsideLL,titleLL;
    private Imageable imageLoader;



    public Banner(@NonNull Context context) {
        this(context,null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initField(context);
        initAttrs(context,attrs);
        initView(context);

    }

    private void initField(Context context){
        this.context = context;
        pageUrls = new ArrayList<>();
        pageViews = new ArrayList<>();
        pageIndics = new ArrayList<>();

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        indicSize = dm.widthPixels / 80;
    }

    private void initAttrs(Context context, AttributeSet attrs){
        if( attrs == null) return;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Banner);

    }

    private void initView(Context context){

    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
