package com.xu.headline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/4/12.
 * 扩展，添加回调
 *
 * @author 许
 */

public class HeadLineVideoPlayer extends JZVideoPlayerStandard {
    private OnStartClickListener onStartClickListener;

    public HeadLineVideoPlayer(Context context) {
        super(context);
    }

    public HeadLineVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        switch (i) {
            case cn.jzvd.R.id.start:
                onStartClickListener.onStartClick();
                onStatePreparing();
                break;
            default:
                break;
        }
    }

    /**
     * 开始按钮回调
     */
    public interface OnStartClickListener {
        /**
         * 开始
         */
        void onStartClick();
    }

    /**
     * 设置开始按钮监听
     *
     * @param onStartClickListener 开始按钮回调
     */
    public void setOnStartClickListener(OnStartClickListener onStartClickListener) {
        this.onStartClickListener = onStartClickListener;
    }

}
