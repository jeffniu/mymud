package com.ngy.mymud.ui;

import android.os.Bundle;

/**
 * Created by niuguangyuan on 6/19/2015.
 */
public class BattleActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BattleView battleView = BattleView_.build(this);
        setContentView(battleView);
    }
}
