package com.xu.headline.ui.activity.channelmanager;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaeger.library.StatusBarUtil;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.r0adkll.slidr.model.SlidrPosition;
import com.xu.headline.R;
import com.xu.headline.adapter.ChannelManagerQuickAdapter;
import com.xu.headline.adapter.entity.ItemDragCallback;
import com.xu.headline.adapter.entity.MultiChannelManagerItem;
import com.xu.headline.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/2.
 *
 * @author xu
 */

public class ChannelManagerActivity extends BaseActivity<IChannelManagerContract.IChannelPresenter> implements IChannelManagerContract.IChannelView {
    @BindView(R.id.rv_channel_manager)
    RecyclerView rvChannelManager;

    private SlidrInterface slidrInterface;

    @Override
    public int setLayoutId() {
        return R.layout.activity_channel_manager;
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }

    @Override
    public IChannelManagerContract.IChannelPresenter setPresenter() {
        return new ChannelManagerPresenter();
    }

    @Override
    public void initOthers() {
        StatusBarUtil.setTransparent(this);
        SlidrConfig slidrConfig = new SlidrConfig.Builder()
                .position(SlidrPosition.TOP)
                .scrimStartAlpha(0f)
                .build();
        slidrInterface = Slidr.attach(this, slidrConfig);
        slidrInterface.unlock();
        rvChannelManager.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //如果已近到达顶部
                if (!rvChannelManager.canScrollVertically(-1)) {
                    slidrInterface.unlock();
                } else {
                    slidrInterface.lock();
                }
            }
        });
        mPresenter.getRecommendChannelList();
    }

    @Override
    public void loadChannels(final List<MultiChannelManagerItem> multiChannelManagerItems) {
        final ChannelManagerQuickAdapter channelManagerQuickAdapter = new ChannelManagerQuickAdapter(multiChannelManagerItems);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        rvChannelManager.setLayoutManager(layoutManager);
        //这里有个坑，关于MultiChannelManagerItem 中的spanSize，因为上面瀑布流设置为4，那么如果spanSize为2，那么每一行有两个
        //如果size为4，那么每一行只有一个。。注意一下
        channelManagerQuickAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return multiChannelManagerItems.get(position).getSpanSize();
            }
        });
        //点击
        channelManagerQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_edit:
                        channelManagerQuickAdapter.setCancelImgVisibility();
                        break;
                    case R.id.img_cancel:

                        break;
                    case R.id.tv_recommend_channel:

                        break;
                    default:
                        break;
                }
            }
        });
        //长按
        channelManagerQuickAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_my_channel:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        //拖拽
        ItemDragCallback callback = new ItemDragCallback(channelManagerQuickAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvChannelManager);
        rvChannelManager.setAdapter(channelManagerQuickAdapter);
    }
}
