package com.ngy.mymud.ui;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by niuguangyuan on 6/21/15.
 */
public class UIUtil {

    public static Typeface getKaiTiFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/kaiti.ttf");
    }

    public static Typeface getXiaoZhuanFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/fangzheng_xiaozhuan.ttf");
    }

    public static Typeface getCartoonFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/fangzheng_katong.ttf");
    }

}
