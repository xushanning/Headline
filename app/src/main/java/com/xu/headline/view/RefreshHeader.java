package com.xu.headline.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xu.headline.R;
import com.xu.headline.utils.TransformUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by xusn10 on 2018/3/21.
 * 自定义刷新header
 *
 * @author xusn10
 */

public class RefreshHeader extends LinearLayout implements com.scwang.smartrefresh.layout.api.RefreshHeader {
    /**
     * 动画是否在执行
     */
    private boolean isShow;
    private TextView textView;
    private AnimatedVectorDrawable animatedVectorDrawable;

    public RefreshHeader(Context context) {
        this(context, null);
    }

    public RefreshHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(VERTICAL);
        ImageView imageView = new ImageView(context);
        animatedVectorDrawable = (AnimatedVectorDrawable) ContextCompat.getDrawable(context, R.drawable.refresh_vector);
        imageView.setImageDrawable(animatedVectorDrawable);
        imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(imageView);
        textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorCustomHeaderLine));
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(textView);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onPulling(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {

    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        Logger.d("刷新完成");
        isShow = false;
        return 0;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                textView.setText("下拉推荐");
                break;
            case Refreshing:
                textView.setText("推荐中");
                //动画
                Logger.d("推荐中。。。");
                animatedVectorDrawable.start();
                animatedVectorDrawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        Observable.create(new ObservableOnSubscribe<Boolean>() {
                            @Override
                            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                                e.onNext(isShow);
                                e.onComplete();
                            }
                        }).compose(TransformUtils.<Boolean>defaultSchedulers())
                                .subscribe(new Consumer<Boolean>() {
                                    @Override
                                    public void accept(Boolean aBoolean) throws Exception {
                                        if (isShow) {
                                            animatedVectorDrawable.start();
                                        }
                                    }
                                });
                    }
                });

                break;
            case ReleaseToRefresh:
                textView.setText("松开推荐");
                break;
            default:
                break;
        }
    }
}
