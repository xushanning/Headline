package com.xu.headline.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/6.
 *
 * @author xu
 */

public class TouTiaoNewsListBean {

    /**
     * message : success
     * data : [{"content":"内容json","code":""}]
     * total_number : 20
     * has_more : true
     * login_status : 0
     * show_et_status : 0
     * post_content_hint : 分享今日新鲜事
     * has_more_to_refresh : true
     * action_to_last_stick : 0
     * feed_flag : 0
     * tips : {"type":"app","display_duration":2,"display_info":"今日头条推荐引擎有20条更新","display_template":"今日头条推荐引擎有%s条更新","open_url":"","web_url":"","download_url":"","app_name":"今日头条","package_name":""}
     */

    private String message;
    @SerializedName("total_number")
    private int totalNumber;
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("login_status")
    private int loginStatus;
    @SerializedName("show_et_status")
    private int showEtStatus;
    @SerializedName("post_content_hint")
    private String postContentHint;
    @SerializedName("has_more_to_refresh")
    private boolean hasMoreToRefresh;
    @SerializedName("action_to_last_stick")
    private int actionToLastStick;
    @SerializedName("feed_flag")
    private int feedFlag;
    private TipsBean tips;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getShowEtStatus() {
        return showEtStatus;
    }

    public void setShowEtStatus(int showEtStatus) {
        this.showEtStatus = showEtStatus;
    }

    public String getPostContentHint() {
        return postContentHint;
    }

    public void setPostContentHint(String postContentHint) {
        this.postContentHint = postContentHint;
    }

    public boolean isHasMoreToRefresh() {
        return hasMoreToRefresh;
    }

    public void setHasMoreToRefresh(boolean hasMoreToRefresh) {
        this.hasMoreToRefresh = hasMoreToRefresh;
    }

    public int getActionToLastStick() {
        return actionToLastStick;
    }

    public void setActionToLastStick(int actionToLastStick) {
        this.actionToLastStick = actionToLastStick;
    }

    public int getFeedFlag() {
        return feedFlag;
    }

    public void setFeedFlag(int feedFlag) {
        this.feedFlag = feedFlag;
    }

    public TipsBean getTips() {
        return tips;
    }

    public void setTips(TipsBean tips) {
        this.tips = tips;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TipsBean {
        /**
         * type : app
         * display_duration : 2
         * display_info : 今日头条推荐引擎有20条更新
         * display_template : 今日头条推荐引擎有%s条更新
         * open_url :
         * web_url :
         * download_url :
         * app_name : 今日头条
         * package_name :
         */

        private String type;
        private int display_duration;
        private String display_info;
        private String display_template;
        private String open_url;
        private String web_url;
        private String download_url;
        private String app_name;
        private String package_name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDisplay_duration() {
            return display_duration;
        }

        public void setDisplay_duration(int display_duration) {
            this.display_duration = display_duration;
        }

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public String getDisplay_template() {
            return display_template;
        }

        public void setDisplay_template(String display_template) {
            this.display_template = display_template;
        }

        public String getOpen_url() {
            return open_url;
        }

        public void setOpen_url(String open_url) {
            this.open_url = open_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }
    }

    public static class DataBean {
        /**
         * content : 内容json
         * code :
         */

        private String content;
        private String code;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
