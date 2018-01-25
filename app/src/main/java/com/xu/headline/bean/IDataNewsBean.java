package com.xu.headline.bean;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/25.
 */

public class IDataNewsBean {

    /**
     * content : 大盘休息才是普涨盈利的开始！中午收盘，看上证指数日线图，说几点：第一，K线今天低开后再次长下影，即便是空中加油也需要横盘整理若干天。第二，均线趋势向上，黄8和紫21平行而并未发散，第一条均线都没破，也不看空。第三，黄8天均线没踩到，那么至少要等待均线上移触碰之，才决定下一步是破位还是再涨。第四，筹码图上典型逼空行情，已经没有主力资金流入了，属于硬拉来维持繁荣。综合判断：大盘滞涨是好事儿，这样非权重股中的绩优白马才有机会，才有散户盈利的机会！天策强调任何行情都有起涨的个股，能不能选出来才是我们要做的事儿！板块上，军工雄安等不予考虑，5G通信芯片等相关产业是波浪底但还不到反弹日子，资源股暂时还是反抽没有看到反弹，可以看好新型消费的崛起和化工的长牛。
     * title : 大盘休息才是普涨盈利的开始！
     * publishDate : 1516853790
     * catPathKey : 财经
     * publishDateStr : 2018-01-25T04:16:30
     * url : http://toutiao.com/group/6514837420905595395/
     * posterScreenName : 每日股市精选
     * tags : ["大盘","均线","上证指数","空中加油"]
     * posterId : 3805589086_3805425585
     * likeCount : 0
     * viewCount : 1339
     * id : 6514837420905595395
     * dislikeCount : 0
     * commentCount : 2
     * imageUrls : ["http://p1.pstatp.com/large/5b4b0003f1f0590c36ac","http://p3.pstatp.com/large/5b4b0003f200e63d5f83"]
     */

    private String content;
    private String title;
    private int publishDate;
    private String catPathKey;
    private String publishDateStr;
    private String url;
    private String posterScreenName;
    private String posterId;
    private int likeCount;
    private int viewCount;
    private String id;
    private int dislikeCount;
    private int commentCount;
    private List<String> tags;
    private List<String> imageUrls;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public String getCatPathKey() {
        return catPathKey;
    }

    public void setCatPathKey(String catPathKey) {
        this.catPathKey = catPathKey;
    }

    public String getPublishDateStr() {
        return publishDateStr;
    }

    public void setPublishDateStr(String publishDateStr) {
        this.publishDateStr = publishDateStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPosterScreenName() {
        return posterScreenName;
    }

    public void setPosterScreenName(String posterScreenName) {
        this.posterScreenName = posterScreenName;
    }

    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
