package com.xu.headline.ui.activity.main;

import android.support.design.widget.TabLayout;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.utils.ToastUtil;

import butterknife.BindView;

/**
 * @author xusn10
 */
public class MainActivity extends BaseActivity<IMainContract.IMainPresenter> implements IMainContract.IMainView {
    @BindView(R.id.guide_tabLayout)
    TabLayout guideTabLayout;
    @BindView(R.id.content_frame_layout)
    FrameLayout contentFrameLayout;
    /**
     * 第一次点击退出时间
     */
    private long exitTime = 0;
    /**
     * 两次退出间隔阈值
     */
    private static final int DOUBLE_EXIT_INTERVAL = 2000;

    @Override
    public IMainContract.IMainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > DOUBLE_EXIT_INTERVAL) {
                ToastUtil.toastShort(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
