package com.xu.headline.ui.fragment.home;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeFragmentPagerAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.NewsSuggestChannelBean;
import com.xu.headline.ui.activity.channelmanager.ChannelManagerActivity;
import com.xu.headline.ui.activity.search.SearchActivity;
import com.xu.headline.utils.ImageTintUtil;
import com.xu.headline.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */
@RuntimePermissions
public class HomeFragment extends BaseFragment<IHomeContract.IHomePresenter> implements IHomeContract.IHomeView {


    @BindView(R.id.tab_layout_home)
    TabLayout tabLayoutHome;
    @BindView(R.id.vp_fragment)
    ViewPager vpHome;
    @BindView(R.id.tv_suggest_search)
    TextView tvSuggestSearch;
    @BindView(R.id.img_un_login)
    ImageView imgUnLogin;
    @BindView(R.id.img_release)
    ImageView imgRelease;
    @BindView(R.id.cl_home_video)
    ConstraintLayout clHomeVideo;
    private PopupWindow window;

    /**
     * 实例化
     *
     * @return HomeFragment实例
     */
    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home_and_video;
    }


    @Override
    public void initOthers() {
        initImage();
        HomeFragmentPermissionsDispatcher.initChannelWithPermissionCheck(this);
        mPresenter.getSuggestSearch();
    }

    /**
     * 初始化图片颜色
     */
    private void initImage() {
        Drawable loginDrawable = imgUnLogin.getDrawable();
        imgUnLogin.setImageDrawable(ImageTintUtil.tintDrawable(loginDrawable, ColorStateList.valueOf(Color.WHITE)));
        Drawable releaseDrawable = imgRelease.getDrawable();
        imgRelease.setImageDrawable(ImageTintUtil.tintDrawable(releaseDrawable, ColorStateList.valueOf(Color.WHITE)));
    }

    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    public void initChannel() {
        mPresenter.initChannel();
    }

    @OnShowRationale(Manifest.permission.READ_PHONE_STATE)
    public void showRationaleReadPhoneState(final PermissionRequest request) {
        new AlertDialog.Builder(getActivity())
                .setMessage(R.string.permissionReadPhoneState)
                .setPositiveButton(R.string.buttonAllow, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        request.proceed();
                    }
                })
                .setNegativeButton(R.string.buttonCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        request.cancel();
                    }
                }).show();
    }

    @OnPermissionDenied(Manifest.permission.READ_PHONE_STATE)
    void showDeniedForCamera() {
        ToastUtil.toastShort(getActivity(), getActivity().getString(R.string.permissionReadPhoneStateDenied));
    }

    @OnNeverAskAgain(Manifest.permission.READ_PHONE_STATE)
    void showNeverAskForCamera() {
        ToastUtil.toastShort(getActivity(), getActivity().getString(R.string.permissionReadPhoneStateDenied));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        HomeFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    public IHomeContract.IHomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void loadData(List<NewsSuggestChannelBean.DataBean> list) {
        if (list != null) {
            //这里用getChildFragmentManager()，获取的是子容器的manager，而getFragmentManager是获取的父容器的manager
            HomeFragmentPagerAdapter homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getChildFragmentManager(), list);
            vpHome.setAdapter(homeFragmentPagerAdapter);
            vpHome.setCurrentItem(1, false);
            tabLayoutHome.setupWithViewPager(vpHome);
        } else {
            Logger.d("获取频道失败");
        }
    }

    @Override
    public void loadSuggestSearch(String suggestString) {
        if (suggestString != null) {
            tvSuggestSearch.setText(suggestString);
        }
    }


    @OnClick({R.id.vSearch, R.id.img_add, R.id.img_un_login, R.id.img_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vSearch:
                Intent searchIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(searchIntent);
                break;
            case R.id.img_add:
                Intent channelManagerIntent = new Intent(getActivity(), ChannelManagerActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getActivity(), R.anim.pop_show_anim, R.anim.pop_hidden_anim);
                ActivityCompat.startActivity(getActivity(), channelManagerIntent, optionsCompat.toBundle());
                //getActivity().overridePendingTransition(R.anim.activity_open,0);
                // showPopWindow();
                break;
            case R.id.img_un_login:
                ToastUtil.toastShort(getActivity(), "登陆!");
                break;
            case R.id.img_release:
                ToastUtil.toastShort(getActivity(), "发布!");
                break;
            default:
                break;
        }
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {
        //无网络展示无网络
    }
}
