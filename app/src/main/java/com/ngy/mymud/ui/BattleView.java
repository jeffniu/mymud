package com.ngy.mymud.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.ngy.mymud.R;
import com.ngy.mymud.ui.widget.BookView;
import com.ngy.mymud.ui.widget.CharacterStatusBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by niuguangyuan on 6/20/2015.
 */

@EViewGroup(R.layout.battle_scene_layout)
public class BattleView extends RelativeLayout {

    @ViewById(R.id.player_status)
    protected CharacterStatusBar mPlayerStatus;

    @ViewById(R.id.testShowHealthChange)
    protected Button mTestShow;

    @ViewById(R.id.battle_description)
    protected BookView mBookView;

    public BattleView(Context context) {
        super(context);
    }

    @AfterViews
    protected void init() {
        final Handler handler = new Handler(Looper.getMainLooper());
        for (int i = 0; i < 40; i++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBookView.addLine("hello, world");
                }
            }, 1000 * i);
        }
        mPlayerStatus.setUsername("牛广远");
        mPlayerStatus.setMaxValue(100, 100);
        mPlayerStatus.setCurrentValue(50, 80);
        mPlayerStatus.showHeathChange(12);
        initTestUI();
    }

    private void initTestUI() {
        mTestShow.setText("Text health change");
        mTestShow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayerStatus.showHeathChange(-12);
            }
        });
    }

}
