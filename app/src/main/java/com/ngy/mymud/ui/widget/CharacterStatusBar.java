package com.ngy.mymud.ui.widget;

import android.content.Context;
import android.widget.LinearLayout;

import com.ngy.mymud.R;

import java.util.zip.Inflater;

/**
 * Created by niuguangyuan on 6/20/2015.
 */
public class CharacterStatusBar extends LinearLayout {

    public CharacterStatusBar(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.character_status_bar_view_layout, this);
    }


}
