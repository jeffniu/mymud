package com.ngy.mymud.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ngy.mymud.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by niuguangyuan on 19/6/15.
 */
@EViewGroup(R.layout.field_page_layout)
public class FieldView extends RelativeLayout {

    @ViewById(R.id.location_name)
    protected TextView mLocationName;

    public FieldView(Context context) {
        super(context);
    }

    @AfterViews
    protected void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/fangzheng_xiaozhuan.ttf");
        mLocationName.setTypeface(tf);
        mLocationName.setText("location name: 场景名");
    }
}
