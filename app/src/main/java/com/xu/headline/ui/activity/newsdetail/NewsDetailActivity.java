package com.xu.headline.ui.activity.newsdetail;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.bean.NewsDetailsBean;
import com.xu.headline.bean.authorinfo.AuthorInfoBean;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.ToastUtil;
import com.xu.headline.view.CustomScrollView;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 新闻详情页
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class NewsDetailActivity extends BaseActivity<INewsDetailContract.INewsDetailPresenter> implements INewsDetailContract.INewsDetailView {
    @BindView(R.id.tv_source_bar)
    TextView tvSourceBar;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.tv_follow_bar)
    TextView tvFollowBar;
    @BindView(R.id.tv_source_blow)
    TextView tvSourceBlow;
    @BindView(R.id.tv_time_blow)
    TextView tvTimeBlow;
    @BindView(R.id.bt_follow_blow)
    Button btFollowBlow;
    @BindView(R.id.custom_scroll_view)
    CustomScrollView customScrollView;
    @BindView(R.id.rl_blow_bar)
    RelativeLayout rlBlowBar;
    @BindView(R.id.img_source_bar)
    ImageView imgSourceBar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_fans_count)
    TextView tvFansCount;
    @BindView(R.id.wb_news_detail)
    WebView wbNewsDetail;
    private static final int ONE_HUNDRED_THOUSAND = 100000;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    /**
     * 一万
     */
    private static final int TEN_THOUSAND = 10000;

    /**
     * 十万
     */


    @Override
    public int setLayoutId() {
        return R.layout.activity_article_detail;
    }

    @Override
    public INewsDetailContract.INewsDetailPresenter setPresenter() {
        return new NewsDetailPresenter();
    }

    @Override
    public void initOthers() {
        super.initOthers();
        long newsID = getIntent().getLongExtra("newsID", 0);
        String channelID = getIntent().getStringExtra("channelID");
        mPresenter.getNewsDetailsData(newsID, channelID);

        //StatusBarUtil.setColorForSwipeBack(this, Color.parseColor("#BDBDBD"), 30);

        customScrollView.setOnScrollChangedListener(new CustomScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldX, int oldY) {
                if (y > rlBlowBar.getHeight()) {
                    imgSourceBar.setVisibility(View.VISIBLE);
                    tvSourceBar.setVisibility(View.VISIBLE);
                    tvFansCount.setVisibility(View.VISIBLE);
                    tvFollowBar.setVisibility(View.VISIBLE);
                } else {
                    imgSourceBar.setVisibility(View.GONE);
                    tvSourceBar.setVisibility(View.GONE);
                    tvFansCount.setVisibility(View.GONE);
                    tvFollowBar.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.tv_follow_bar, R.id.bt_follow_blow, R.id.img_back, R.id.v_write_comment, R.id.img_comment_count, R.id.img_collection, R.id.img_share})
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
            case R.id.v_write_comment:
                ToastUtil.toastShort(this, "写评论~");
                break;
            case R.id.img_collection:
                ToastUtil.toastShort(this, "收藏~");
                break;
            case R.id.img_share:
                ToastUtil.toastShort(this, "分享~");
                break;
            case R.id.img_comment_count:
                ToastUtil.toastShort(this, "评论数量~");
                break;
            default:
                break;
        }
    }

    @Override
    public void loadNewsDetailsData(NewsDetailsBean newsDetailsBean) {
        tvSourceBar.setText(newsDetailsBean.getH5_extra().getSource());
        tvSourceBlow.setText(newsDetailsBean.getH5_extra().getSource());
        //tvCommentCount.setText("");
        tvTimeBlow.setText("");
        tvTitle.setText(newsDetailsBean.getH5_extra().getTitle());
        WebSettings webSettings = wbNewsDetail.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        Logger.d(newsDetailsBean.getContent());
        List<NewsDetailsBean.WebpImageDetailBean> imgList = newsDetailsBean.getWebp_image_detail();

        wbNewsDetail.loadDataWithBaseURL(null, handleHtmlString(newsDetailsBean.getContent(), imgList),
                "text/html", "UTF-8", null);

    }

    @Override
    public void loadAuthorInfo(AuthorInfoBean authorInfoBean) {

        tvSourceBar.setText(authorInfoBean.getUser_info().getName());
        if (authorInfoBean.getUser_info().getFans_count() == 0) {
            tvFansCount.setVisibility(View.GONE);
        } else {
            tvFansCount.setText(transformFansCount(authorInfoBean.getUser_info().getFans_count()) + getString(R.string.fans));
        }
        ImageLoaderUtil.loadCircleImage(this, authorInfoBean.getUser_info().getAvatar_url(), imgSourceBar);
        ImageLoaderUtil.loadCircleImage(this, authorInfoBean.getUser_info().getAvatar_url(), ivLogo);
        tvCommentCount.setText(transformFansCount(authorInfoBean.getComment_count()) + "");
    }

    /**
     * 转换粉丝数量
     *
     * @param fansCount 原始数量
     * @return 转换后的数量
     */
    private String transformFansCount(int fansCount) {
        String transformString;
        //一万到十万变成如:  6.4万
        if (fansCount > TEN_THOUSAND && fansCount < ONE_HUNDRED_THOUSAND) {
            BigDecimal bigDecimal = new BigDecimal((float) fansCount / TEN_THOUSAND);
            float transformCount = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
            transformString = transformCount + getString(R.string.ten_thousand);
        } else if (fansCount > ONE_HUNDRED_THOUSAND) {
            //十万以上 变成如: 34万  158万
            transformString = fansCount / TEN_THOUSAND + getString(R.string.ten_thousand);
        } else {
            //一万以下的，直接返回
            transformString = fansCount + "";
        }
        return transformString;
    }

    private String handleHtmlString(String originalHtml, List<NewsDetailsBean.WebpImageDetailBean> imgList) {
        String reg = "<a[^>]+?href=([\\s\\S]*?)<\\/a>";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(originalHtml);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        boolean result = matcher.find();
        while (result) {
            matcher.appendReplacement(sb, "<img src=\"" + imgList.get(i).getUrl() + "\"style=\"width:100%;height:auto\"");
            i++;
            Logger.d(matcher.group());
            result = matcher.find();
        }
        matcher.appendTail(sb);
        Logger.d(sb.toString());
        return sb.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
