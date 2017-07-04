package com.example.libbanner.loader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by chaos
 * On 17-7-4.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public abstract class ImageLoader implements Imageable<ImageView> {


    @Override
    public ImageView create(Context context) {
        return new ImageView(context);
    }
}
