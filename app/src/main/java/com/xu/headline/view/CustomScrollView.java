package com.xu.headline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2018/1/20.
 * 自定义滑动，接口回调监听
 *
 * @author xu
 */

public class CustomScrollView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(l, t, oldl, oldt);
        }
    }

    /**
     * 滑动监听接口
     */
    public interface OnScrollChangedListener {
        /**
         * 滑动的时候
         *
         * @param x
         * @param y
         * @param oldX
         * @param oldY
         */
        void onScrollChanged(int x, int y, int oldX, int oldY);
    }

    /**
     * 设置监听
     *
     * @param onScrollChangedListener 监听接口
     */
    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }
}
