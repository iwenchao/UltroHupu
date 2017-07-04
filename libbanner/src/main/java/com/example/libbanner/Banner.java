package com.example.libbanner;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.libbanner.utils.Config;
import com.example.libbanner.view.BannerPager;

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


    public Banner(@NonNull Context context) {
        this(context,null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

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
