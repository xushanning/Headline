package com.xu.headline.bean.authorinfo;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/11.
 *
 * @author xu
 *         头条号信息
 */

public class AuthorInfoBean {


    /**
     * ban_bury : 1
     * ban_comment : 0
     * ban_digg : 0
     * bury_count : 0
     * comment_count : 8390
     * context : {"tip":""}
     * detail_show_flags : 0
     * digg_count : 6
     * display_url : http://toutiao.com/group/6525910609031070216/
     * filter_words : [{"id":"5:9300275","name":"拉黑作者:央视新闻"},{"id":"2:11781439","name":"不想看:民生"},{"id":"6:39687","name":"不想看:海南"}]
     * group_flags : 2
     * group_id : 6525910609031070216
     * h5_extra : {"have_red_pack":0,"is_original":false,"is_subscribed":0,"media":{"avatar_url":"http://p2.pstatp.com/large/4306/2602403105","can_be_praised":false,"description":"中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。","id":4492956276,"name":"央视新闻","pgc_custom_menu":"[]","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"中央电视台新闻中心官方帐号\"}","user_decoration":"","user_verified":true}}
     * ignore_web_transform : 0
     * info_flag : 7
     * is_wenda : 0
     * like_count : 1312
     * like_desc : 关心这篇文章，会推荐更多此类内容
     * log_pb : {"impr_id":"20180224162428010010023222209F57"}
     * media_info : {"avatar_url":"http://p2.pstatp.com/large/4306/2602403105","description":"中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。","media_id":4492956276,"name":"央视新闻","special_column":[{"column_no":1,"name":"V观2016两会"},{"column_no":2,"name":"习主席访问捷克"},{"column_no":4,"name":"大国工匠"}],"subcribed":0,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"中央电视台新闻中心官方帐号\"}","user_id":4492956276,"user_verified":true}
     * recommend_sponsor : {"icon_url":"http://p3.pstatp.com/origin/13ef000096960314fff4","label":"帮上头条","target_url":"https://i.snssdk.com/ad/pgc_promotion/mobile/create/?group_id=6525910609031070216&item_id=6525910609031070216"}
     * related_gallery : []
     * related_video_section : 0
     * repin_count : 6903
     * script :
     * share_url : https://m.toutiao.com/group/6525910609031070216/?iid=25206805877&app=news_article&timestamp=1519460668
     * source : 央视新闻
     * ug_install_aid : 0
     * url : https://mp.weixin.qq.com/s/2BbzHLDLi0J3HhWofWImcA
     * user_bury : 0
     * user_digg : 0
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/4306/2602403105","description":"中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。","fans_count":93202959,"follow":0,"media_id":4492956276,"name":"央视新闻","special_column":[{"column_no":1,"name":"V观2016两会"},{"column_no":2,"name":"习主席访问捷克"},{"column_no":4,"name":"大国工匠"}],"subcribed":0,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"中央电视台新闻中心官方帐号\"}","user_decoration":"","user_id":4492956276,"user_verified":true}
     * user_repin : 0
     */

    private int ban_bury;
    private int ban_comment;
    private int ban_digg;
    private int bury_count;
    private int comment_count;
    private String context;
    private int detail_show_flags;
    private int digg_count;
    private String display_url;
    private int group_flags;
    private long group_id;
    private H5ExtraBean h5_extra;
    private int ignore_web_transform;
    private int info_flag;
    private int is_wenda;
    private int like_count;
    private String like_desc;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private RecommendSponsorBean recommend_sponsor;
    private int related_video_section;
    private int repin_count;
    private String script;
    private String share_url;
    private String source;
    private int ug_install_aid;
    private String url;
    private int user_bury;
    private int user_digg;
    private UserInfoBean user_info;
    private int user_repin;
    private List<FilterWordsBean> filter_words;
    private List<?> related_gallery;


    public List<BaseOrderedInfoBean> getOrdered_info() {
        return ordered_info;
    }

    public void setOrdered_info(List<BaseOrderedInfoBean> ordered_info) {
        this.ordered_info = ordered_info;
    }

    private List<BaseOrderedInfoBean> ordered_info;

    public int getBan_bury() {
        return ban_bury;
    }

    public void setBan_bury(int ban_bury) {
        this.ban_bury = ban_bury;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBan_digg() {
        return ban_digg;
    }

    public void setBan_digg(int ban_digg) {
        this.ban_digg = ban_digg;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getDetail_show_flags() {
        return detail_show_flags;
    }

    public void setDetail_show_flags(int detail_show_flags) {
        this.detail_show_flags = detail_show_flags;
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

    public int getGroup_flags() {
        return group_flags;
    }

    public void setGroup_flags(int group_flags) {
        this.group_flags = group_flags;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public H5ExtraBean getH5_extra() {
        return h5_extra;
    }

    public void setH5_extra(H5ExtraBean h5_extra) {
        this.h5_extra = h5_extra;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public int getInfo_flag() {
        return info_flag;
    }

    public void setInfo_flag(int info_flag) {
        this.info_flag = info_flag;
    }

    public int getIs_wenda() {
        return is_wenda;
    }

    public void setIs_wenda(int is_wenda) {
        this.is_wenda = is_wenda;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getLike_desc() {
        return like_desc;
    }

    public void setLike_desc(String like_desc) {
        this.like_desc = like_desc;
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

    public RecommendSponsorBean getRecommend_sponsor() {
        return recommend_sponsor;
    }

    public void setRecommend_sponsor(RecommendSponsorBean recommend_sponsor) {
        this.recommend_sponsor = recommend_sponsor;
    }

    public int getRelated_video_section() {
        return related_video_section;
    }

    public void setRelated_video_section(int related_video_section) {
        this.related_video_section = related_video_section;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getUg_install_aid() {
        return ug_install_aid;
    }

    public void setUg_install_aid(int ug_install_aid) {
        this.ug_install_aid = ug_install_aid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUser_bury() {
        return user_bury;
    }

    public void setUser_bury(int user_bury) {
        this.user_bury = user_bury;
    }

    public int getUser_digg() {
        return user_digg;
    }

    public void setUser_digg(int user_digg) {
        this.user_digg = user_digg;
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

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<?> getRelated_gallery() {
        return related_gallery;
    }

    public void setRelated_gallery(List<?> related_gallery) {
        this.related_gallery = related_gallery;
    }

    public static class H5ExtraBean {
        /**
         * have_red_pack : 0
         * is_original : false
         * is_subscribed : 0
         * media : {"avatar_url":"http://p2.pstatp.com/large/4306/2602403105","can_be_praised":false,"description":"中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。","id":4492956276,"name":"央视新闻","pgc_custom_menu":"[]","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"中央电视台新闻中心官方帐号\"}","user_decoration":"","user_verified":true}
         */

        private int have_red_pack;
        private boolean is_original;
        private int is_subscribed;
        private MediaBean media;

        public int getHave_red_pack() {
            return have_red_pack;
        }

        public void setHave_red_pack(int have_red_pack) {
            this.have_red_pack = have_red_pack;
        }

        public boolean isIs_original() {
            return is_original;
        }

        public void setIs_original(boolean is_original) {
            this.is_original = is_original;
        }

        public int getIs_subscribed() {
            return is_subscribed;
        }

        public void setIs_subscribed(int is_subscribed) {
            this.is_subscribed = is_subscribed;
        }

        public MediaBean getMedia() {
            return media;
        }

        public void setMedia(MediaBean media) {
            this.media = media;
        }

        public static class MediaBean {
            /**
             * avatar_url : http://p2.pstatp.com/large/4306/2602403105
             * can_be_praised : false
             * description : 中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。
             * id : 4492956276
             * name : 央视新闻
             * pgc_custom_menu : []
             * user_auth_info : {"auth_type": "0", "auth_info": "中央电视台新闻中心官方帐号"}
             * user_decoration :
             * user_verified : true
             */

            private String avatar_url;
            private boolean can_be_praised;
            private String description;
            private long id;
            private String name;
            private String pgc_custom_menu;
            private String user_auth_info;
            private String user_decoration;
            private boolean user_verified;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public boolean isCan_be_praised() {
                return can_be_praised;
            }

            public void setCan_be_praised(boolean can_be_praised) {
                this.can_be_praised = can_be_praised;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPgc_custom_menu() {
                return pgc_custom_menu;
            }

            public void setPgc_custom_menu(String pgc_custom_menu) {
                this.pgc_custom_menu = pgc_custom_menu;
            }

            public String getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(String user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public String getUser_decoration() {
                return user_decoration;
            }

            public void setUser_decoration(String user_decoration) {
                this.user_decoration = user_decoration;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 20180224162428010010023222209F57
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
         * avatar_url : http://p2.pstatp.com/large/4306/2602403105
         * description : 中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。
         * media_id : 4492956276
         * name : 央视新闻
         * special_column : [{"column_no":1,"name":"V观2016两会"},{"column_no":2,"name":"习主席访问捷克"},{"column_no":4,"name":"大国工匠"}]
         * subcribed : 0
         * user_auth_info : {"auth_type": "0", "auth_info": "中央电视台新闻中心官方帐号"}
         * user_id : 4492956276
         * user_verified : true
         */

        private String avatar_url;
        private String description;
        private long media_id;
        private String name;
        private int subcribed;
        private String user_auth_info;
        private long user_id;
        private boolean user_verified;
        private List<SpecialColumnBean> special_column;

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

        public int getSubcribed() {
            return subcribed;
        }

        public void setSubcribed(int subcribed) {
            this.subcribed = subcribed;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
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

        public List<SpecialColumnBean> getSpecial_column() {
            return special_column;
        }

        public void setSpecial_column(List<SpecialColumnBean> special_column) {
            this.special_column = special_column;
        }

        public static class SpecialColumnBean {
            /**
             * column_no : 1
             * name : V观2016两会
             */

            private int column_no;
            private String name;

            public int getColumn_no() {
                return column_no;
            }

            public void setColumn_no(int column_no) {
                this.column_no = column_no;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class RecommendSponsorBean {
        /**
         * icon_url : http://p3.pstatp.com/origin/13ef000096960314fff4
         * label : 帮上头条
         * target_url : https://i.snssdk.com/ad/pgc_promotion/mobile/create/?group_id=6525910609031070216&item_id=6525910609031070216
         */

        private String icon_url;
        private String label;
        private String target_url;

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getTarget_url() {
            return target_url;
        }

        public void setTarget_url(String target_url) {
            this.target_url = target_url;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : http://p3.pstatp.com/thumb/4306/2602403105
         * description : 中央电视台新闻中心头条新闻官方帐号，是央视重大新闻、突发事件、重点报道的发布平台。
         * fans_count : 93202959
         * follow : 0
         * media_id : 4492956276
         * name : 央视新闻
         * special_column : [{"column_no":1,"name":"V观2016两会"},{"column_no":2,"name":"习主席访问捷克"},{"column_no":4,"name":"大国工匠"}]
         * subcribed : 0
         * user_auth_info : {"auth_type": "0", "auth_info": "中央电视台新闻中心官方帐号"}
         * user_decoration :
         * user_id : 4492956276
         * user_verified : true
         */

        private String avatar_url;
        private String description;
        private int fans_count;
        private int follow;
        private long media_id;
        private String name;
        private int subcribed;
        private String user_auth_info;
        private String user_decoration;
        private long user_id;
        private boolean user_verified;
        private List<SpecialColumnBeanX> special_column;

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

        public int getFans_count() {
            return fans_count;
        }

        public void setFans_count(int fans_count) {
            this.fans_count = fans_count;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
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

        public int getSubcribed() {
            return subcribed;
        }

        public void setSubcribed(int subcribed) {
            this.subcribed = subcribed;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public String getUser_decoration() {
            return user_decoration;
        }

        public void setUser_decoration(String user_decoration) {
            this.user_decoration = user_decoration;
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

        public List<SpecialColumnBeanX> getSpecial_column() {
            return special_column;
        }

        public void setSpecial_column(List<SpecialColumnBeanX> special_column) {
            this.special_column = special_column;
        }

        public static class SpecialColumnBeanX {
            /**
             * column_no : 1
             * name : V观2016两会
             */

            private int column_no;
            private String name;

            public int getColumn_no() {
                return column_no;
            }

            public void setColumn_no(int column_no) {
                this.column_no = column_no;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 5:9300275
         * name : 拉黑作者:央视新闻
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
