package com.ngy.mymud.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ngy.mymud.R;
import com.ngy.mymud.ui.UIUtil;
import com.ngy.mymud.ui.support.CustomTypefaceSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuguangyuan on 6/21/15.
 */
public class BookView extends RelativeLayout {

    protected RecyclerView mBodyListView;
    protected BookAdapter mAdapter;
    private Context mContext;

    public BookView(Context context) {
        super(context);
        init(context);
    }

    public BookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        inflate(context, R.layout.book_view_layout, this);
        mBodyListView = (RecyclerView) findViewById(R.id.body_listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mBodyListView.setLayoutManager(layoutManager);
        mAdapter = new BookAdapter(context);
        mBodyListView.setAdapter(mAdapter);
    }

    /**
     * add one line content to the book and scroll to the end
     * @param line
     */
    private void addLine(CharSequence line) {
        if (mAdapter != null) {
            mAdapter.addLine(line);
            mBodyListView.getLayoutManager().scrollToPosition(mAdapter.mMsgList.size()-1);
        }
    }

    /**
     * add one script line content to the book and scroll to the end
     * @param line
     */
    public void addScriptLine(CharSequence line) {
        SpannableString spanLine = new SpannableString(line);
        spanLine.setSpan(new CustomTypefaceSpan("", UIUtil.getKaiTiFont(mContext)), 0,
                spanLine.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        addLine(spanLine);
    }

    /**
     * clear the content of the book
     */
    public void clear() {
        if (mAdapter != null) {
            mAdapter.clear();
        }
    }

    public static class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

        private List<CharSequence> mMsgList;
        private Context mContext;

        public BookAdapter(Context context) {
            mContext = context;
            mMsgList = new ArrayList<>();
        }

        public void addLine(CharSequence line) {
            mMsgList.add(line);
            notifyDataSetChanged();
        }

        public void addScriptLine(CharSequence line) {
            SpannableString spanLine = new SpannableString(line);
            spanLine.setSpan(new CustomTypefaceSpan("", UIUtil.getKaiTiFont(mContext)), 0,
                    line.length()-1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            mMsgList.add(spanLine);
            notifyDataSetChanged();
        }

        public void clear() {
            mMsgList.clear();
            notifyDataSetChanged();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder  {

            TextView mTextView;

            public ViewHolder(TextView itemView) {
                super(itemView);
                mTextView = itemView;
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(mContext);
            ViewHolder viewHolder = new ViewHolder(textView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mMsgList.get(position));
        }

        @Override
        public int getItemCount() {
            return mMsgList.size();
        }
    }
}
