package com.ngy.mymud.ui;

import android.os.Bundle;

/**
 * Created by niuguangyuan on 18/6/15.
 */
public class FieldActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FieldView view = FieldView_.build(this);
        setContentView(view);
    }
}
