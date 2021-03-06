package com.xu.headline.ui.activity.search;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeListQuickAdapter;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.bean.response.IDataNewsBean;

import java.util.List;

import butterknife.BindView;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;

/**
 * Created by Administrator on 2018/1/20.
 *
 * @author xu
 */

public class SearchActivity extends BaseActivity<ISearchContract.ISearchPresenter> implements ISearchContract.ISearchView {
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.cl_search)
    ConstraintLayout clSearch;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;
    private HomeListQuickAdapter homeListQuickAdapter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initOthers() {
        super.initOthers();
        //点击输入法的搜索
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                mPresenter.getSearchResult(string);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSearch.setLayoutManager(layoutManager);
      //  homeListQuickAdapter = new HomeListQuickAdapter(R.layout.item_home_detail, new ArrayList<IDataNewsBean>());
        homeListQuickAdapter.setUpFetchEnable(true);
        rvSearch.setAdapter(homeListQuickAdapter);
        //下拉刷新
        homeListQuickAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                Logger.d("下拉刷新");
            }
        });
        //加载更多
        homeListQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Logger.d("加载更多");
            }
        }, rvSearch);
        //条目点击
        homeListQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                NewsListBean.ListBean listBean = (NewsListBean.ListBean) adapter.getItem(position);
//                Intent intent = new Intent(SearchActivity.this, ArticleDetailActivity.class);
//                intent.putExtra("time", listBean.getTime());
//                intent.putExtra("title", listBean.getTitle());
//                intent.putExtra("source", listBean.getSrc());
//                intent.putExtra("detailURL", listBean.getWeburl());
//                startActivity(intent);
            }
        });
        homeListQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d(position + "个x号被点击了");

            }
        });
    }


    @Override
    public ISearchContract.ISearchPresenter setPresenter() {
        return new SearchPresenter();
    }


    @Override
    public void loadSearchResult(List<IDataNewsBean> searchListBeans) {
        Logger.d("+============" + searchListBeans.size());
        clSearch.setVisibility(View.GONE);
      //  homeListQuickAdapter.setNewData(searchListBeans);
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
