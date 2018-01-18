package com.xu.headline.ui.fragment.home;

import com.orhanobut.logger.Logger;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.ChannelsBean;
import com.xu.headline.net.BaseHttpResultObserver;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomePresenter extends BasePresenter<IHomeContract.IHomeView> implements IHomeContract.IHomePresenter {

    private static final String SECRET = "5f387b649a5a49c7bd389f39e8f08212";
    private static final String APPID = "54582";

    @Override
    public void getChannelInfo() {
        RetrofitFactory.getTouTiaoApi()
                .getChannels(APPID, SECRET)
                .compose(TransformUtils.<BaseResBean<ChannelsBean>>defaultSchedulers())
                .subscribe(new BaseHttpResultObserver<ChannelsBean>() {
                    @Override
                    protected void onSuccess(ChannelsBean channelsBean) {
                        Logger.d(channelsBean.getChannelList().size());
                        mView.loadData(channelsBean.getChannelList());
                    }
                });
//        List<ChannelBean> channelBeans = new ArrayList<>();
//        List<String> channelName = Arrays.asList(MyApplication.getContextInstance().getResources().getStringArray(R.array.home_channel));
//        List<String> channelID = Arrays.asList(MyApplication.getContextInstance().getResources().getStringArray(R.array.home_channel_id));
//        for (int i = 0; i < channelName.size(); i++) {
//            ChannelBean channelBean = new ChannelBean();
//            channelBean.setChannelName(channelName.get(i));
//            channelBean.setChannelID(channelID.get(i));
//            channelBeans.add(channelBean);
//        }
//        mView.loadData(channelBeans);

    }
}
