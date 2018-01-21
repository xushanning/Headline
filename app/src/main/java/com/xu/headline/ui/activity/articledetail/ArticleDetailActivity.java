package com.xu.headline.ui.activity.articledetail;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.utils.ToastUtil;
import com.xu.headline.view.CustomScrollView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 新闻详情页
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class ArticleDetailActivity extends BaseActivity<IArticleDetailContract.IArticleDetailPresenter> implements IArticleDetailContract.IArticleDetailView {
    @BindView(R.id.tv_source_bar)
    TextView tvSourceBar;
    @BindView(R.id.tv_time_bar)
    TextView tvTimeBar;
    @BindView(R.id.tv_follow_bar)
    TextView tvtFollowBar;
    @BindView(R.id.tv_source_blow)
    TextView tvSourceBlow;
    @BindView(R.id.tv_time_blow)
    TextView tvTimeBlow;
    @BindView(R.id.bt_follow_blow)
    Button btFollowBlow;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.custom_scroll_view)
    CustomScrollView customScrollView;
    @BindView(R.id.rl_blow_bar)
    RelativeLayout rlBlowBar;
    @BindView(R.id.img_source_bar)
    ImageView imgSourceBar;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int setLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    public IArticleDetailContract.IArticleDetailPresenter setPresenter() {
        return new ArticleDetailPresenter();
    }

    @Override
    public void initOthers() {
        super.initOthers();
        setWebViewSetting();
        String detailURL = getIntent().getStringExtra("detailURL");
        String time = getIntent().getStringExtra("time");
        String source = getIntent().getStringExtra("source");
        String title = getIntent().getStringExtra("title");
        tvSourceBar.setText(source);
        tvSourceBlow.setText(source);
        tvTimeBar.setText(time);
        tvTimeBlow.setText(time);
        tvTitle.setText(title);
        webView.loadUrl(detailURL);
        //StatusBarUtil.setColorForSwipeBack(this, Color.parseColor("#BDBDBD"), 30);

        customScrollView.setOnScrollChangedListener(new CustomScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldX, int oldY) {
                if (y > rlBlowBar.getHeight()) {
                    imgSourceBar.setVisibility(View.VISIBLE);
                    tvSourceBar.setVisibility(View.VISIBLE);
                    tvTimeBar.setVisibility(View.VISIBLE);
                    tvtFollowBar.setVisibility(View.VISIBLE);
                } else {
                    imgSourceBar.setVisibility(View.GONE);
                    tvSourceBar.setVisibility(View.GONE);
                    tvTimeBar.setVisibility(View.GONE);
                   tvtFollowBar.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.tv_follow_bar, R.id.bt_follow_blow, R.id.img_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_follow_bar:
                ToastUtil.toastShort(this, "关注功能尚在开发中~");
                break;
            case R.id.bt_follow_blow:
                ToastUtil.toastShort(this, "关注功能尚在开发中~");
                break;
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }

    private void setWebViewSetting() {
        class JsObject {
            @JavascriptInterface
            public void jsFunctionimg(final String i) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Logger.d("run: " + i);
                    }
                });

            }

        }
        webView.addJavascriptInterface(new JsObject(), "jscontrolimg");
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollbarOverlay(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setHorizontalScrollbarOverlay(false);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setDomStorageEnabled(true);
        // webView.loadUrl("file:///android_asset/ifeng/post_detail.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //String aid = getIntent().getStringExtra("aid");
                //  mPresenter.getData(aid);
            }
        });
    }

}
