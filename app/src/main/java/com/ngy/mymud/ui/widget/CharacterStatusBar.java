package com.ngy.mymud.ui.widget;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ngy.mymud.R;

import java.util.zip.Inflater;

/**
 * Created by niuguangyuan on 6/20/2015.
 */
public class CharacterStatusBar extends LinearLayout {

    private TextView mNameText;
    private ProgressBar mHealthBar;
    private ProgressBar mMagicBar;
    private TextView mHeathChangeText;

    public CharacterStatusBar(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.character_status_bar_view_layout, this);
        mNameText = (TextView) findViewById(R.id.character_display_name);
        mHealthBar = (ProgressBar) findViewById(R.id.character_health_bar);
        mMagicBar = (ProgressBar) findViewById(R.id.character_magic_bar);
        mHeathChangeText = (TextView) findViewById(R.id.character_health_change_text);
    }

}
