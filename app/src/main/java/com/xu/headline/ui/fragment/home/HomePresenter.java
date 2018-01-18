package com.xu.headline.ui.fragment.home;

import android.support.v4.content.ContextCompat;

import com.xu.headline.MyApplication;
import com.xu.headline.R;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.bean.ChannelBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomePresenter extends BasePresenter<IHomeContract.IHomeView> implements IHomeContract.IHomePresenter {


    @Override
    public void getChannelInfo() {
        List<ChannelBean> channelBeans = new ArrayList<>();
        List<String> channelName = Arrays.asList(MyApplication.getContextInstance().getResources().getStringArray(R.array.home_channel));
        List<String> channelID = Arrays.asList(MyApplication.getContextInstance().getResources().getStringArray(R.array.home_channel_id));
        for (int i = 0; i < channelName.size(); i++) {
            ChannelBean channelBean = new ChannelBean();
            channelBean.setChannelName(channelName.get(i));
            channelBean.setChannelID(channelID.get(i));
            channelBeans.add(channelBean);
        }
        mView.loadData(channelBeans);

    }
}
