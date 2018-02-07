package com.xu.headline.ui.fragment.home;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeFragmentPagerAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.NewsChannelListBean;
import com.xu.headline.bean.NewsSuggestChannelBean;
import com.xu.headline.ui.activity.search.SearchActivity;
import com.xu.headline.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
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
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.tv_suggest_search)
    TextView tvSuggestSearch;

    private HomeFragmentPagerAdapter homeFragmentPagerAdapter;

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
        return R.layout.fragment_home;
    }


    @Override
    public void initOthers() {
        HomeFragmentPermissionsDispatcher.initChannelWithPermissionCheck(this);
        mPresenter.getSuggestSearch();
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
            homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getChildFragmentManager(), list);
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


    @OnClick({R.id.vSearch, R.id.img_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vSearch:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.img_add:
                ToastUtil.toastShort(getActivity(), "增加频道!");
                break;
            default:
                break;
        }
    }


}
