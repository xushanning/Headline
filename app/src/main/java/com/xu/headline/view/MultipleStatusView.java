package com.xu.headline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.xu.headline.R;

import java.util.ArrayList;
import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * @author 言吾許
 *         显示多种页面状态的view
 */

public class MultipleStatusView extends RelativeLayout {

    /**
     * 无网络布局id
     */
    private int noNetworkViewResId;
    /**
     * 错误布局id
     */
    private int errorViewResId;
    /**
     * 内容布局id
     */
    private int contentViewResId;
    /**
     * 正在加载布局id
     */
    private int loadingViewResId;
    /**
     * 无布局
     */
    private static final int NULL_RESOURCE_ID = -1;

    private LayoutInflater mInflater;
    /**
     * 展示的view的类型
     */
    private int viewStatus;
    private static final int STATUS_CONTENT = 0x00;
    private static final int STATUS_LOADING = 0x01;
    private static final int STATUS_ERROR = 0x02;
    private static final int STATUS_NO_NETWORK = 0x03;

    private View noNetworkView;
    private View errorView;
    private View contentView;
    private View loadingView;

    private static final RelativeLayout.LayoutParams DEFAULT_LAYOUT_PARAMS = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT);
    /**
     * 把异常状态的view的id存放起来
     */
    private List<Integer> otherId = new ArrayList<>();

    private OnClickListener onClickListener;

    public MultipleStatusView(Context context) {
        this(context, null);
    }

    public MultipleStatusView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultipleStatusView, defStyleAttr, 0);
        noNetworkViewResId = typedArray.getResourceId(R.styleable.MultipleStatusView_noNetworkView, R.layout.view_no_network);
        errorViewResId = typedArray.getResourceId(R.styleable.MultipleStatusView_errorView, R.layout.view_error);
        loadingViewResId = typedArray.getResourceId(R.styleable.MultipleStatusView_loadingView, R.layout.view_loading);
        contentViewResId = typedArray.getResourceId(R.styleable.MultipleStatusView_contentView, NULL_RESOURCE_ID);
        typedArray.recycle();
        mInflater = LayoutInflater.from(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        showContent();
    }


    /**
     * 显示内容视图
     */
    public final void showContent() {
        viewStatus = STATUS_CONTENT;
        if (contentView == null && contentViewResId != NULL_RESOURCE_ID) {
            contentView = mInflater.inflate(contentViewResId, null);
            addView(contentView, 0, DEFAULT_LAYOUT_PARAMS);
        }
        showContentView();
    }

    /**
     * 显示无网络视图
     */
    public final void showNoNetwork() {
        viewStatus = STATUS_NO_NETWORK;
        if (noNetworkView == null) {
            noNetworkView = mInflater.inflate(noNetworkViewResId, null);
            otherId.add(noNetworkView.getId());
            //在这里加载重试等布局
            ConstraintLayout constraintLayout = noNetworkView.findViewById(R.id.cl_no_network);
            constraintLayout.setOnClickListener(onClickListener);
            addView(noNetworkView, 0, DEFAULT_LAYOUT_PARAMS);
        }
        showViewById(noNetworkView.getId());
    }

    /**
     * 显示加载视图
     */
    public final void showLoading() {
        viewStatus = STATUS_LOADING;
        if (loadingView == null) {
            loadingView = mInflater.inflate(loadingViewResId, null);
            //荧光动画
            ShimmerLayout shimmerLayout = loadingView.findViewById(R.id.sl_loading);
            shimmerLayout.setShimmerAnimationDuration(1500);
            shimmerLayout.setShimmerColor(R.color.color_loading_Shimmer);
            shimmerLayout.startShimmerAnimation();
            otherId.add(loadingView.getId());
            addView(loadingView, 0, DEFAULT_LAYOUT_PARAMS);
        }
        showViewById(loadingView.getId());
    }

    /**
     * 显示错误视图
     */
    public final void showError() {
        viewStatus = STATUS_ERROR;
        if (errorView == null) {
            errorView = mInflater.inflate(errorViewResId, null);
            otherId.add(errorView.getId());
            addView(errorView, 0, DEFAULT_LAYOUT_PARAMS);
        }
        showViewById(errorView.getId());
    }

    private void showContentView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            //如果子view在这个list中，那么gone，否则，则代表是content的view，显示
            view.setVisibility(otherId.contains(view.getId()) ? View.GONE : View.VISIBLE);
        }
    }

    private void showViewById(int viewId) {
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.setVisibility(childView.getId() == viewId ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 无网络重试点击
     *
     * @param onRetryClickListener 重试事件
     */
    public void setOnRetryClickListener(OnClickListener onRetryClickListener) {
        this.onClickListener = onRetryClickListener;
    }

    /**
     * 销毁view
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearView(loadingView, errorView, noNetworkView);
        if (otherId != null) {
            otherId.clear();
        }
        if (onClickListener != null) {
            onClickListener = null;
        }
        mInflater = null;
    }

    private void clearView(View... views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            if (view != null) {
                removeView(view);
            }
        }
    }
}
