package com.ngy.mymud.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ngy.mymud.R;
import com.ngy.mymud.ui.UIUtil;


/**
 * Created by niuguangyuan on 6/20/2015.
 */
public class CharacterStatusBar extends LinearLayout {

    private TextView mNameText;
    private ProgressBar mHealthBar;
    private ProgressBar mMagicBar;
    private TextView mHeathChangeText;

    private int currentHealth;
    private int currentMagic;

    public CharacterStatusBar(Context context) {
        super(context);
        init(context);
    }

    public CharacterStatusBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        inflate(context, R.layout.character_status_bar_view_layout, this);
        mNameText = (TextView) findViewById(R.id.character_display_name);
        mNameText.setTypeface(UIUtil.getCartoonFont(getContext()));
        mHealthBar = (ProgressBar) findViewById(R.id.character_health_bar);
        mMagicBar = (ProgressBar) findViewById(R.id.character_magic_bar);
        mHeathChangeText = (TextView) findViewById(R.id.character_health_change_text);
    }

    public void setMaxValue(int maxHealth, int maxMagic) {
        mHealthBar.setMax(maxHealth);
        mMagicBar.setMax(maxMagic);
    }

    public void setCurrentValue(int currentHealth, int currentMagic) {
        mHealthBar.setProgress(currentHealth);
        mMagicBar.setProgress(currentMagic);
    }

    public void setUsername(String username) {
        mNameText.setText(username);
    }

    public void showHeathChange(int changeValue) {
        mHeathChangeText.setText(String.valueOf(changeValue));
        //TODO: show a health change animation for 1 second
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
        AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
        mHeathChangeText.startAnimation(fadeIn);
        mHeathChangeText.startAnimation(fadeOut);
        fadeIn.setDuration(200);
        fadeIn.setFillAfter(true);
        fadeOut.setDuration(200);
        fadeOut.setFillAfter(true);
        fadeOut.setStartOffset(1000+fadeIn.getStartOffset());
    }

}
