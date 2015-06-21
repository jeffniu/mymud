package com.ngy.mymud.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.ngy.mymud.R;

/**
 * Created by niuguangyuan on 6/21/15.
 */
public class BookView extends RelativeLayout {

    protected RecyclerView mBodyListView;

    public BookView(Context context) {
        super(context);
        init(context);
    }

    public BookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.book_view_layout, this);
        mBodyListView = (RecyclerView) findViewById(R.id.body_listview);
    }

    /**
     * add one line content to the book and scroll to the end
     * @param line
     */
    public void addLine(String line) {

    }

    /**
     * clear the content of the book
     */
    public void clear() {}

}
