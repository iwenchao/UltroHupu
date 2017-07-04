package com.example.libbanner.loader;

import android.content.Context;
import android.view.View;

import java.io.Serializable;

/**
 * Created by chaos
 * On 17-7-4.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public interface Imageable<V extends View> extends Serializable {

    void into(Context context,Object path,V view);

    V create(Context context);

}
