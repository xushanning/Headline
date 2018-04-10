package com.xu.headline.bean.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TouTiaoListItemBean {


    /**
     * abstract : 本计价周期以来，在美元指数下跌
     * action_extra : {"channel_id ":3189398996}
     * action_list : [{"action":1,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_sub_type : 0
     * article_type : 0
     * article_url : http://www.cs.com.cn/ssgs/hyzx/201802/t20180207_5703006.html
     * article_alt_url : http://m.toutiao.com/group/article/6519346771167019271/
     * ban_comment : 0
     * behot_time : 1517983616
     * bury_count : 0
     * cell_flag : 11
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 420
     * content_decoration :
     * cursor : 1517983616999
     * digg_count : 0
     * display_url : http://toutiao.com/group/6519593967720333827/
     * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"}]
     * forward_info : {"forward_count":345}
     * group_id : 6519593967720333827
     * gallary_image_count : 4
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * has_image : true
     * hot : 0
     * ignore_web_transform : 1
     * is_subject : false
     * item_id : 6519593967720333827
     * image_list : [{"height":270,"uri":"list/61400026ddc563df6ffd","url":"http://p9.pstatp.com/list/190x124/61400026ddc563df6ffd.webp","url_list":[{"url":"http://p9.pstatp.com/list/190x124/61400026ddc563df6ffd.webp"},{"url":"http://pb1.pstatp.com/list/190x124/61400026ddc563df6ffd.webp"},{"url":"http://pb3.pstatp.com/list/190x124/61400026ddc563df6ffd.webp"}],"width":480}]
     * item_version : 0
     * keywords : 油价,变化率,原油,下调,成品油
     * label : 广告
     * level : 0
     * label_style : 3
     * large_image_list : [{"height":720,"uri":"large/5dd2000a2061ea813ce4","url":"http://p1.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp","url_list":[{"url":"http://p1.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp"},{"url":"http://pb3.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp"},{"url":"http://pb9.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp"}],"width":1280}]
     * log_pb : {"impr_id":"201802071407310100030490170554FD"}
     * media_info : {"avatar_url":"http://p2.pstatp.com/thumb/1629/1083334908","follow":false,"is_star_user":false,"media_id":3701662541,"name":"中国证券报","recommend_reason":"","recommend_type":0,"user_id":3701139224,"user_verified":false,"verified_content":""}
     * media_name : 中国证券报
     * preload_web : 1
     * middle_image : {"height":337,"uri":"list/61460003b6406c81e6e9","url":"http://p3.pstatp.com/list/190x124/61460003b6406c81e6e9.webp","url_list":[{"url":"http://p3.pstatp.com/list/190x124/61460003b6406c81e6e9.webp"},{"url":"http://pb9.pstatp.com/list/190x124/61460003b6406c81e6e9.webp"},{"url":"http://pb1.pstatp.com/list/190x124/61460003b6406c81e6e9.webp"}],"width":600}
     * natant_level : 2
     * publish_time : 1517960880
     * raw_ad_data : {"disable_download_dialog":1,"display_type":2,"expire_seconds":315708828,"id":90464467209,"log_extra":{"ad_price ":"WnqXo__nDQZaepej_ - cNBjNQpf1bbCwM9gFeRA ","convert_component_suspend ":0,"convert_id ":0,"external_action ":19,"req_id ":"201802071407310100030490170554 FD ","rit ":1},"type":"web","web_title":"桔子树"}
     * read_count : 212118
     * repin_count : 660
     * rid : 201802071407310100030490170554FD
     * share_count : 634
     * share_url : http://m.toutiao.com/group/6519593967720333827/?iid=25206805877&app=news_article
     * show_dislike : true
     * show_portrait : false
     * show_portrait_article : false
     * source : 中国证券报
     * source_icon_style : 6
     * source_open_url : sslocal://profile?uid=3701139224
     * tag : news_finance
     * tag_id : 6519593967720333827
     * tip : 0
     * title : 成品油或迎今年首降 降幅将逾百元
     * ugc_recommend : {"activity":"","reason":""}
     * url : http://www.cs.com.cn/ssgs/hyzx/201802/t20180207_5703006.html
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/1629/1083334908","description":"\u201c中证公告快递\u201d是由中国证券报\u2022中证网倾力打造的专业化、综合性移动应用程序，方便投资者第一时间获知最新资讯及公告信息。","follow":false,"follower_count":0,"name":"中国证券报","user_id":3701139224,"user_verified":false}
     * user_repin : 0
     * user_verified : 0
     * verified_content :
     * video_style : 0
     */

    @SerializedName("abstract")
    private String abstractX;
    private ActionExtraBean action_extra;
    private int aggr_type;
    private boolean allow_download;
    private int article_sub_type;
    private int article_type;
    private String article_url;
    private String article_alt_url;
    private int ban_comment;
    private int behot_time;
    private int bury_count;
    private int cell_flag;
    private int cell_layout_style;
    private int cell_type;
    private int comment_count;
    private String content_decoration;
    private long cursor;
    private int digg_count;
    private String display_url;
    private ForwardInfoBean forward_info;
    private long group_id;
    private int gallary_image_count;
    private boolean has_m3u8_video;
    private int has_mp4_video;
    private boolean has_video;
    private boolean has_image;
    private int hot;
    private int ignore_web_transform;
    private boolean is_subject;
    private long item_id;
    private int item_version;
    private String keywords;
    private String label;
    private int level;
    private int label_style;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private String media_name;
    private int preload_web;
    private MiddleImageBean middle_image;
    private int natant_level;
    private int publish_time;
    private RawAdDataBean raw_ad_data;
    private int read_count;
    private int repin_count;
    private String rid;
    private int share_count;
    private String share_url;
    private boolean show_dislike;
    private boolean show_portrait;
    private boolean show_portrait_article;
    private String source;
    private int source_icon_style;
    private String source_open_url;
    private String tag;
    private long tag_id;
    private int tip;
    private String title;
    private UgcRecommendBean ugc_recommend;
    private String url;
    private UserInfoBean user_info;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private int video_style;
    private List<ActionListBean> action_list;
    private List<FilterWordsBean> filter_words;
    private List<ImageListBean> image_list;
    private List<LargeImageListBean> large_image_list;

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public ActionExtraBean getAction_extra() {
        return action_extra;
    }

    public void setAction_extra(ActionExtraBean action_extra) {
        this.action_extra = action_extra;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getArticle_alt_url() {
        return article_alt_url;
    }

    public void setArticle_alt_url(String article_alt_url) {
        this.article_alt_url = article_alt_url;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent_decoration() {
        return content_decoration;
    }

    public void setContent_decoration(String content_decoration) {
        this.content_decoration = content_decoration;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public boolean isHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(boolean has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLabel_style() {
        return label_style;
    }

    public void setLabel_style(int label_style) {
        this.label_style = label_style;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public int getPreload_web() {
        return preload_web;
    }

    public void setPreload_web(int preload_web) {
        this.preload_web = preload_web;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getNatant_level() {
        return natant_level;
    }

    public void setNatant_level(int natant_level) {
        this.natant_level = natant_level;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public RawAdDataBean getRaw_ad_data() {
        return raw_ad_data;
    }

    public void setRaw_ad_data(RawAdDataBean raw_ad_data) {
        this.raw_ad_data = raw_ad_data;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public boolean isShow_dislike() {
        return show_dislike;
    }

    public void setShow_dislike(boolean show_dislike) {
        this.show_dislike = show_dislike;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<ImageListBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
        this.image_list = image_list;
    }

    public List<LargeImageListBean> getLarge_image_list() {
        return large_image_list;
    }

    public void setLarge_image_list(List<LargeImageListBean> large_image_list) {
        this.large_image_list = large_image_list;
    }

    public static class ActionExtraBean {
        /**
         * channel_id  : 3189398996
         */

        private long channel_id;

        public long getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(long channel_id) {
            this.channel_id = channel_id;
        }
    }

    public static class ForwardInfoBean {
        /**
         * forward_count : 345
         */

        private int forward_count;

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 201802071407310100030490170554FD
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class MediaInfoBean {
        /**
         * avatar_url : http://p2.pstatp.com/thumb/1629/1083334908
         * follow : false
         * is_star_user : false
         * media_id : 3701662541
         * name : 中国证券报
         * recommend_reason :
         * recommend_type : 0
         * user_id : 3701139224
         * user_verified : false
         * verified_content :
         */

        private String avatar_url;
        private boolean follow;
        private boolean is_star_user;
        private long media_id;
        private String name;
        private String recommend_reason;
        private int recommend_type;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class MiddleImageBean {
        /**
         * height : 337
         * uri : list/61460003b6406c81e6e9
         * url : http://p3.pstatp.com/list/190x124/61460003b6406c81e6e9.webp
         * url_list : [{"url":"http://p3.pstatp.com/list/190x124/61460003b6406c81e6e9.webp"},{"url":"http://pb9.pstatp.com/list/190x124/61460003b6406c81e6e9.webp"},{"url":"http://pb1.pstatp.com/list/190x124/61460003b6406c81e6e9.webp"}]
         * width : 600
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBean> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p3.pstatp.com/list/190x124/61460003b6406c81e6e9.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class RawAdDataBean {
        /**
         * disable_download_dialog : 1
         * display_type : 2
         * expire_seconds : 315708828
         * id : 90464467209
         * log_extra : {"ad_price ":"WnqXo__nDQZaepej_ - cNBjNQpf1bbCwM9gFeRA ","convert_component_suspend ":0,"convert_id ":0,"external_action ":19,"req_id ":"201802071407310100030490170554 FD ","rit ":1}
         * type : web
         * web_title : 桔子树
         */

        private int disable_download_dialog;
        private int display_type;
        private int expire_seconds;
        private long id;
        private LogExtraBean log_extra;
        private String type;
        private String web_title;

        public int getDisable_download_dialog() {
            return disable_download_dialog;
        }

        public void setDisable_download_dialog(int disable_download_dialog) {
            this.disable_download_dialog = disable_download_dialog;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public int getExpire_seconds() {
            return expire_seconds;
        }

        public void setExpire_seconds(int expire_seconds) {
            this.expire_seconds = expire_seconds;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public LogExtraBean getLog_extra() {
            return log_extra;
        }

        public void setLog_extra(LogExtraBean log_extra) {
            this.log_extra = log_extra;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWeb_title() {
            return web_title;
        }

        public void setWeb_title(String web_title) {
            this.web_title = web_title;
        }

        public static class LogExtraBean {
            /**
             * ad_price  : WnqXo__nDQZaepej_ - cNBjNQpf1bbCwM9gFeRA
             * convert_component_suspend  : 0
             * convert_id  : 0
             * external_action  : 19
             * req_id  : 201802071407310100030490170554 FD
             * rit  : 1
             */

            private String ad_price;
            private int convert_component_suspend;
            private int convert_id;
            private int external_action;
            private String req_id;
            private int rit;

            public String getAd_price() {
                return ad_price;
            }

            public void setAd_price(String ad_price) {
                this.ad_price = ad_price;
            }

            public int getConvert_component_suspend() {
                return convert_component_suspend;
            }

            public void setConvert_component_suspend(int convert_component_suspend) {
                this.convert_component_suspend = convert_component_suspend;
            }

            public int getConvert_id() {
                return convert_id;
            }

            public void setConvert_id(int convert_id) {
                this.convert_id = convert_id;
            }

            public int getExternal_action() {
                return external_action;
            }

            public void setExternal_action(int external_action) {
                this.external_action = external_action;
            }

            public String getReq_id() {
                return req_id;
            }

            public void setReq_id(String req_id) {
                this.req_id = req_id;
            }

            public int getRit() {
                return rit;
            }

            public void setRit(int rit) {
                this.rit = rit;
            }
        }
    }

    public static class UgcRecommendBean {
        /**
         * activity :
         * reason :
         */

        private String activity;
        private String reason;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : http://p3.pstatp.com/thumb/1629/1083334908
         * description : “中证公告快递”是由中国证券报•中证网倾力打造的专业化、综合性移动应用程序，方便投资者第一时间获知最新资讯及公告信息。
         * follow : false
         * follower_count : 0
         * name : 中国证券报
         * user_id : 3701139224
         * user_verified : false
         */

        private String avatar_url;
        private String description;
        private boolean follow;
        private int follower_count;
        private String name;
        private long user_id;
        private boolean user_verified;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public int getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(int follower_count) {
            this.follower_count = follower_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * is_selected : false
         * name : 看过了
         */

        private String id;
        private boolean is_selected;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ImageListBean {
        /**
         * height : 270
         * uri : list/61400026ddc563df6ffd
         * url : http://p9.pstatp.com/list/190x124/61400026ddc563df6ffd.webp
         * url_list : [{"url":"http://p9.pstatp.com/list/190x124/61400026ddc563df6ffd.webp"},{"url":"http://pb1.pstatp.com/list/190x124/61400026ddc563df6ffd.webp"},{"url":"http://pb3.pstatp.com/list/190x124/61400026ddc563df6ffd.webp"}]
         * width : 480
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBeanX> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p9.pstatp.com/list/190x124/61400026ddc563df6ffd.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LargeImageListBean {
        /**
         * height : 720
         * uri : large/5dd2000a2061ea813ce4
         * url : http://p1.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp
         * url_list : [{"url":"http://p1.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp"},{"url":"http://pb3.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp"},{"url":"http://pb9.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp"}]
         * width : 1280
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBeanXX> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanXX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanXX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanXX {
            /**
             * url : http://p1.pstatp.com/large/w640/5dd2000a2061ea813ce4.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
