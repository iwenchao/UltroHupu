package com.example.libbanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.libbanner.loader.Imageable;
import com.example.libbanner.utils.BannerScroller;
import com.example.libbanner.utils.Config;
import com.example.libbanner.view.BannerPager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaos
 * On 17-7-4.
 * Email:iwenchaos@gmail.com
 * Description: 图片轮播组件
 */

public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    public static final String TAG = Banner.class.getSimpleName();

    private Context context;
    /*view page configuration*/
    private int indicMargin = Config.Banner.MARGIN;
    private int indicWidth;
    private int indicHeight;
    private int indicSize;
    private int indicStyle;
    private int delayTime ;
    private int scrollDuration;
    private boolean autoPlay;
    private boolean canScroll;
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
    private List pageUrls;
    private List<View> pageViews;
    private List<ImageView> pageIndics;
    private BannerPager bannerPager;
    private BannerScroller scroller;
    private TextView banTitleTv, numIndicInsideTv, numIndicTv;
    private LinearLayout indicatorLL, indicatorInsideLL, titleLL;
    private Imageable imageLoader;
    private OnBannerItemClickListener onBannerItemClickListener;
    private BannerPagerAdapter pagerAdapter;


    public Banner(@NonNull Context context) {
        this(context, null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initField(context);
        initAttrs(context, attrs);
        initView(context);
        initPagerScroller();
    }

    private void initField(Context context) {
        this.context = context;
        titles = new ArrayList<>();
        pageUrls = new ArrayList<>();
        pageViews = new ArrayList<>();
        pageIndics = new ArrayList<>();

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        indicSize = dm.widthPixels / 80;
        layoutResId = R.layout.banner;
        scaleType = 1;
        indicStyle = Config.Indicator.Style.CIRCLE_INDICATOR;
        delayTime = Config.Banner.DELAY_TIME;
        scrollDuration = Config.Banner.DURATION;
        autoPlay = Config.Banner.AUTO_PLAY;
        canScroll = Config.Banner.CAN_SCROLL;
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Banner);
        indicWidth = typedArray.getDimensionPixelSize(R.styleable.Banner_indicator_width, indicSize);
        indicHeight = typedArray.getDimensionPixelSize(R.styleable.Banner_indicator_height, indicSize);
        indicMargin = typedArray.getDimensionPixelSize(R.styleable.Banner_indicator_margin, Config.Banner.MARGIN);
        indicSelectedResId = typedArray.getResourceId(R.styleable.Banner_indicator_drawable_selected, R.drawable.circle_gray);
        indicUnselectResId = typedArray.getResourceId(R.styleable.Banner_indicator_drawable_unselected, R.drawable.circle_white);
        scaleType = typedArray.getInt(R.styleable.Banner_image_scale_type, scaleType);
        delayTime = typedArray.getInt(R.styleable.Banner_delay_time, Config.Banner.DELAY_TIME);
        scrollDuration = typedArray.getInt(R.styleable.Banner_scroll_duration, Config.Banner.DURATION);
        autoPlay = typedArray.getBoolean(R.styleable.Banner_auto_play, Config.Banner.AUTO_PLAY);
        titleBackground = typedArray.getColor(R.styleable.Banner_title_background, Config.Banner.TITLE_BACKGROUND);
        titleHeight = typedArray.getDimensionPixelSize(R.styleable.Banner_title_height, Config.Banner.TITLE_HEIGHT);
        titleTxtColor = typedArray.getColor(R.styleable.Banner_title_textcolor, Config.Banner.TITLE_TEXT_COLOR);
        titleTxtSize = typedArray.getDimensionPixelSize(R.styleable.Banner_title_textsize, Config.Banner.TITLE_TEXT_SIZE);
        layoutResId = typedArray.getResourceId(R.styleable.Banner_layout_id, layoutResId);
        typedArray.recycle();
    }

    private void initView(Context context) {
        View content = LayoutInflater.from(context).inflate(layoutResId, this, true);
        bannerPager = content.findViewById(R.id.bannerPager);
        titleLL = content.findViewById(R.id.titleView);
        indicatorLL = content.findViewById(R.id.circleIndicator);
        indicatorInsideLL = content.findViewById(R.id.indicatorInside);
        banTitleTv = content.findViewById(R.id.bannerTitle);
        numIndicTv = content.findViewById(R.id.numIndicator);
        numIndicInsideTv = content.findViewById(R.id.numIndicatorInside);
    }

    private void initPagerScroller() {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            scroller = new BannerScroller(getContext());
            scroller.setDuration(scrollDuration);
            mScroller.set(bannerPager, scroller);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public Banner start(){
        setBannerStyle();
        setPagerList(pageUrls);
        setData();
        return this;
    }

    private void setData() {
        pageSize = pageUrls.size();
        currentPage = 1;
        if(pagerAdapter == null){
            pagerAdapter = new BannerPagerAdapter();
            bannerPager.addOnPageChangeListener(this);
        }
        bannerPager.setAdapter(pagerAdapter);
        bannerPager.setFocusable(true);
        if(indicGravity != -1)
            indicatorLL.setGravity(indicGravity);
        if(canScroll && pageSize > 1){
            bannerPager.setScrollable(true);
        }else {
            bannerPager.setScrollable(false);
        }
        if (autoPlay)
            startAutoPlay();

    }

    public void startAutoPlay(){

    }


    private void setBannerStyle() {
        int visibility;
        if (pageUrls.size() > 1)
            visibility = View.VISIBLE;
        else
            visibility = View.GONE;
        switch (indicStyle) {
            case Config.Indicator.Style.CIRCLE_INDICATOR:
                indicatorLL.setVisibility(visibility);
                break;
            case Config.Indicator.Style.NUM_INDICATOR:
                indicatorLL.setVisibility(visibility);
                break;
            case Config.Indicator.Style.NUM_WITH_TITLE_INDICATOR:
                numIndicInsideTv.setVisibility(visibility);
                setBannerTitleStyle();
                break;
            case Config.Indicator.Style.CIRCLE_WITH_TITLE_INDICATOR:
                indicatorLL.setVisibility(visibility);
                setBannerTitleStyle();
                break;
            case Config.Indicator.Style.CIRCLE_WITH_INSIDE_TITLE_INDICATOR:
                indicatorInsideLL.setVisibility(visibility);
                setBannerTitleStyle();
                break;
        }
    }
    private void setBannerTitleStyle(){
        if(titles.size() != pageUrls.size()  ){
            throw new RuntimeException("[Banner] --> The number of titles and images is different");
        }
        if(titleBackground != -1){
            titleLL.setBackgroundColor(titleBackground);
        }
        if (titleHeight != -1) {
            titleLL.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleHeight));
        }
        if (titleTxtColor != -1) {
            banTitleTv.setTextColor(titleTxtColor);
        }
        if (titleTxtSize != -1) {
            banTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleTxtSize);
        }
        if (titles != null && titles.size() > 0) {
            banTitleTv.setText(titles.get(0));
            banTitleTv.setVisibility(View.VISIBLE);
            titleLL.setVisibility(View.VISIBLE);
        }
    }
    private void setPagerList(List<?> pageUrls) {
        if(pageUrls == null || pageUrls.size() <=0){
            Log.e(TAG, "Please set the images data.");
            return;
        }
        initPage();
        for (int i = 0; i <= pageUrls.size() + 1; i++) {
            View imageView = null;
            if (imageLoader != null) {
                imageView = imageLoader.create(context);
            }
            if (imageView == null) {
                imageView = new ImageView(context);
            }
            setScaleType(imageView);
            Object url = null;
            if (i == 0) {
                url = pageUrls.get(pageSize - 1);
            } else if (i == pageSize + 1) {
                url = pageUrls.get(0);
            } else {
                url = pageUrls.get(i - 1);
            }
            pageViews.add(imageView);
            if (imageLoader != null)
                imageLoader.into(context, url, imageView);
            else
                Log.e(TAG, "Please set images loader.");
        }

    }

    private void initPage() {
        pageViews.clear();
        if (indicStyle == Config.Indicator.Style.CIRCLE_INDICATOR ||
                indicStyle == Config.Indicator.Style.CIRCLE_WITH_TITLE_INDICATOR ||
                indicStyle == Config.Indicator.Style.CIRCLE_WITH_INSIDE_TITLE_INDICATOR) {
            createIndicators();
        } else if (indicStyle == Config.Indicator.Style.NUM_WITH_TITLE_INDICATOR) {
            numIndicTv.setText("1/" + pageSize);
        } else if (indicStyle == Config.Indicator.Style.NUM_INDICATOR) {
            numIndicTv.setText("1/" + pageSize);
        }
    }

    private void createIndicators(){
        pageIndics.clear();
        indicatorLL.removeAllViews();
        indicatorInsideLL.removeAllViews();
        for (int page = 0; page < pageSize; page++) {
            ImageView indic = new ImageView(context);
            indic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(indicWidth, indicHeight);
            params.leftMargin = indicMargin;
            params.rightMargin = indicMargin;
            if (page == 0) {
                indic.setImageResource(indicSelectedResId);
            } else {
                indic.setImageResource(indicUnselectResId);
            }

            pageIndics.add(indic);
            if (indicStyle == Config.Indicator.Style.CIRCLE_INDICATOR ||
                    indicStyle == Config.Indicator.Style.CIRCLE_WITH_TITLE_INDICATOR)
                indicatorLL.addView(indic, params);
            else if (indicStyle == Config.Indicator.Style.CIRCLE_WITH_INSIDE_TITLE_INDICATOR)
                indicatorInsideLL.addView(indic, params);

        }
    }
    private void setScaleType(View imageView) {
        if (imageView instanceof ImageView) {
            ImageView view = ((ImageView) imageView);
            switch (scaleType) {
                case 0:
                    view.setScaleType(ImageView.ScaleType.CENTER);
                    break;
                case 1:
                    view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                case 2:
                    view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
                case 3:
                    view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case 4:
                    view.setScaleType(ImageView.ScaleType.FIT_END);
                    break;
                case 5:
                    view.setScaleType(ImageView.ScaleType.FIT_START);
                    break;
                case 6:
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                case 7:
                    view.setScaleType(ImageView.ScaleType.MATRIX);
                    break;
            }

        }
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

    public Banner setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer){
        bannerPager.setPageTransformer(reverseDrawingOrder,transformer);
        return this;
    }

    public Imageable getImageLoader() {
        return imageLoader;
    }

    public Banner setImageLoader(Imageable imageLoader) {
        this.imageLoader = imageLoader;
        return this;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public Banner setDelayTime(int delayTime) {
        this.delayTime = delayTime;
        return this;
    }

    public int getScrollDuration() {
        return scrollDuration;
    }

    public Banner setScrollDuration(int scrollDuration) {
        this.scrollDuration = scrollDuration;
        return this;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public Banner setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
        return this;
    }

    public boolean isCanScroll() {
        return canScroll;
    }

    public Banner setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
        return this;
    }

    public int getIndicSelectedResId() {
        return indicSelectedResId;
    }

    public Banner setIndicSelectedResId(int indicSelectedResId) {
        this.indicSelectedResId = indicSelectedResId;
        return this;
    }

    public int getIndicUnselectResId() {
        return indicUnselectResId;
    }

    public Banner setIndicUnselectResId(int indicUnselectResId) {
        this.indicUnselectResId = indicUnselectResId;
        return this;
    }

    public OnBannerItemClickListener getOnBannerItemClickListener() {
        return onBannerItemClickListener;
    }

    public Banner setOnBannerItemClickListener(OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
        return this;
    }

    public int getLayoutResId() {
        return layoutResId;
    }

    public Banner setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
        return this;
    }

    public int getIndicGravity() {
        return indicGravity;
    }

    public Banner setIndicGravity(int indicGravity) {
        switch (indicGravity) {
            case Config.Indicator.Gravity.LEFT:
                this.indicGravity = Config.Indicator.Gravity.LEFT | Gravity.CENTER_VERTICAL;
                break;
            case Config.Indicator.Gravity.CENTER:
                this.indicGravity = Gravity.CENTER;
                break;
            case Config.Indicator.Gravity.RIGHT:
                this.indicGravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                break;
            default:

                break;
        }
        return this;
    }
    public Banner setOffscreenPageLimit(int limit) {
        if (bannerPager != null) {
            bannerPager.setOffscreenPageLimit(limit);
        }
        return this;
    }
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<?> getPageUrls() {
        return pageUrls;
    }

    public Banner setPageUrls(List<?> pageUrls) {
        this.pageUrls = pageUrls;
        return this;
    }

    public List<View> getPageViews() {
        return pageViews;
    }

    public void setPageViews(List<View> pageViews) {
        this.pageViews = pageViews;
    }

    public List<ImageView> getPageIndics() {
        return pageIndics;
    }

    public void setPageIndics(List<ImageView> pageIndics) {
        this.pageIndics = pageIndics;
    }

    public int getScaleType() {
        return scaleType;
    }

    public Banner setScaleType(int scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    public int getTitleHeight() {
        return titleHeight;
    }

    public void setTitleHeight(int titleHeight) {
        this.titleHeight = titleHeight;
    }

    public int getTitleBackground() {
        return titleBackground;
    }

    public void setTitleBackground(int titleBackground) {
        this.titleBackground = titleBackground;
    }

    public int getTitleTxtColor() {
        return titleTxtColor;
    }

    public void setTitleTxtColor(int titleTxtColor) {
        this.titleTxtColor = titleTxtColor;
    }

    public int getTitleTxtSize() {
        return titleTxtSize;
    }

    public void setTitleTxtSize(int titleTxtSize) {
        this.titleTxtSize = titleTxtSize;
    }

    public interface OnBannerItemClickListener{
        void onBannerItemClick(int position);
    }

    static class BannerPagerAdapter extends PagerAdapter{


        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
