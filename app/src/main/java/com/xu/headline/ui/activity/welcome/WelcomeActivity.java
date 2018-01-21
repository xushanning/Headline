package com.xu.headline.ui.activity.welcome;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.headline.ui.activity.main.MainActivity;
import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TransformUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;

/**
 * @author xusn10
 */
public class WelcomeActivity extends BaseActivity<IWelcomeContract.IWelcomePresenter> implements IWelcomeContract.IWelcomeView {


    @BindView(R.id.img_ad)
    ImageView imgAd;
    @BindView(R.id.tv_skip)
    TextView tvSkip;
    /**
     * 倒计时
     */
    private static final int COUNT_DOWN = 5;

    @Override
    public int setLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initOthers() {
        super.initOthers();
        //必应每日壁纸 来源于 https://www.dujin.org/fenxiang/jiaocheng/3618.html.
        ImageLoaderUtil.loadImage(this, "https://api.dujin.org/bing/1920.php", imgAd);
        //jumpToMain();
        mCompositeDisposable.add(Observable.interval(0, 1, TimeUnit.SECONDS)
                .compose(TransformUtils.<Long>defaultSchedulers())
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        return COUNT_DOWN - aLong.intValue();
                    }
                })
                .take(COUNT_DOWN + 1)
                .subscribeWith(new DisposableObserver<Integer>() {

                    @Override
                    public void onNext(Integer integer) {
                        tvSkip.setText("跳过 " + (integer + 1));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        jumpToMain();
                    }
                })
        );
    }

    @Override
    public IWelcomeContract.IWelcomePresenter setPresenter() {
        return new WelcomePresenter();
    }

    private void jumpToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @OnClick(R.id.tv_skip)
    public void onViewClicked() {
        jumpToMain();
    }


}
