package com.xu.headline.ui.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.jaeger.library.StatusBarUtil;
import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.ui.fragment.home.HomeFragment;
import com.xu.headline.ui.fragment.personalcenter.PersonalCenterFragment;
import com.xu.headline.ui.fragment.smallheadline.SmallHeadlineFragment;
import com.xu.headline.ui.fragment.video.VideoFragment;
import com.xu.headline.utils.ToastUtil;

import butterknife.BindView;


/**
 * @author xusn10
 */
public class MainActivity extends BaseActivity<IMainContract.IMainPresenter> implements IMainContract.IMainView {

    @BindView(R.id.content_frame_layout)
    FrameLayout contentFrameLayout;
    @BindView(R.id.guide_bottom_navigation)
    BottomNavigationBar guideBottomNavigation;

    /**
     * 第一次点击退出时间
     */
    private long exitTime = 0;
    /**
     * 两次退出间隔阈值
     */
    private static final int DOUBLE_EXIT_INTERVAL = 2000;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment[] fragments;
    private static final int SHOW_HOME = 0;
    private static final int SHOW_VIDEO = 1;
    private static final int SHOW_SMALL_HEADLINE = 2;
    private static final int SHOW_PERSONAL_CENTER = 3;
    /**
     * 默认展示的是首页
     */
    private int lastNavigationPosition = SHOW_HOME;

    @Override
    public IMainContract.IMainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initOthers() {
        //设置沉浸式
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, 0, null);
        initView();
    }

    /**
     * 初始化页面
     */
    private void initView() {
        fragmentManager = getSupportFragmentManager();
        fragments = new Fragment[4];
        showFragment(SHOW_HOME);
        TextBadgeItem textBadgeItem = new TextBadgeItem();
        textBadgeItem.setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorGuideSelected)
                .setText("6")
                .setHideOnSelect(true);

        guideBottomNavigation
                .setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.mipmap.home, getString(R.string.main_home)).setBadgeItem(textBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.video, getString(R.string.main_video)))
                .addItem(new BottomNavigationItem(R.mipmap.small_headline, getString(R.string.main_small_headline)))
                .addItem(new BottomNavigationItem(R.mipmap.personal_center, getString(R.string.main_personal_center)))
                .setActiveColor(R.color.colorGuideSelected)
                .setInActiveColor(R.color.colorGuideUnSelected)
                .setBarBackgroundColor(R.color.colorGuideBackground)
                .setFirstSelectedPosition(SHOW_HOME)
                .initialise();
        guideBottomNavigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                showFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }


    /**
     * 展示fragment
     *
     * @param targetFragmentPosition 目标fragment的位置
     */
    private void showFragment(int targetFragmentPosition) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragments[lastNavigationPosition] != null) {
            fragmentTransaction.hide(fragments[lastNavigationPosition]);
        }
        if (fragments[targetFragmentPosition] == null) {
            fragmentTransaction.add(R.id.content_frame_layout, createFragment(targetFragmentPosition));
        } else {
            fragmentTransaction.show(fragments[targetFragmentPosition]);
        }
        fragmentTransaction.commit();
        lastNavigationPosition = targetFragmentPosition;
    }

    /**
     * 创建fragment
     *
     * @param showFragment tag位置
     * @return 返回对应的fragment
     */
    private Fragment createFragment(int showFragment) {
        Fragment fragment = null;
        switch (showFragment) {
            case SHOW_HOME:
                fragment = HomeFragment.newInstance();
                break;
            case SHOW_VIDEO:
                fragment = VideoFragment.newInstance();
                break;
            case SHOW_SMALL_HEADLINE:
                fragment = SmallHeadlineFragment.newInstance();
                break;
            case SHOW_PERSONAL_CENTER:
                fragment = PersonalCenterFragment.newInstance();
                break;
            default:
                break;
        }
        fragments[showFragment] = fragment;
        return fragment;
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
