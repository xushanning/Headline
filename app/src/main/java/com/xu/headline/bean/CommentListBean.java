package com.xu.headline.bean;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/9.
 *
 * @author xu
 */

public class CommentListBean {

    /**
     * message : success
     * data : [{"comment":{"id":1591897498741779,"text":"要是我们有中-35就好了。","content_rich_span":"","reply_count":0,"reply_list":[],"digg_count":0,"bury_count":0,"create_time":1518151759,"score":0.34566956758499146,"user_id":7012220657,"user_name":"摇醉红尘","remark_name":"","user_profile_image_url":"http://p0.pstatp.com/origin/3795/3044413937","user_verified":false,"is_following":0,"is_followed":0,"is_blocking":0,"is_blocked":0,"is_pgc_author":0,"author_badge":[],"verified_reason":"","user_bury":0,"user_digg":0,"user_relation":0,"user_auth_info":"","user_decoration":"","media_info":{"name":"","avatar_url":""},"platform":"feifei"},"cell_type":1}]
     * total_number : 790
     * has_more : true
     * fold_comment_count : 0
     * detail_no_comment : 0
     * ban_comment : false
     * ban_face : false
     * go_topic_detail : 1
     * show_add_forum : 1
     * stick_comments : []
     * stick_total_number : 0
     * stick_has_more : false
     * tab_info : {"current_tab_index":0,"tabs":["热度","时间"]}
     * stable : true
     */

    private String message;
    private int total_number;
    private boolean has_more;
    private int fold_comment_count;
    private int detail_no_comment;
    private boolean ban_comment;
    private boolean ban_face;
    private int go_topic_detail;
    private int show_add_forum;
    private int stick_total_number;
    private boolean stick_has_more;
    private TabInfoBean tab_info;
    private boolean stable;
    private List<DataBean> data;
    private List<?> stick_comments;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getFold_comment_count() {
        return fold_comment_count;
    }

    public void setFold_comment_count(int fold_comment_count) {
        this.fold_comment_count = fold_comment_count;
    }

    public int getDetail_no_comment() {
        return detail_no_comment;
    }

    public void setDetail_no_comment(int detail_no_comment) {
        this.detail_no_comment = detail_no_comment;
    }

    public boolean isBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(boolean ban_comment) {
        this.ban_comment = ban_comment;
    }

    public boolean isBan_face() {
        return ban_face;
    }

    public void setBan_face(boolean ban_face) {
        this.ban_face = ban_face;
    }

    public int getGo_topic_detail() {
        return go_topic_detail;
    }

    public void setGo_topic_detail(int go_topic_detail) {
        this.go_topic_detail = go_topic_detail;
    }

    public int getShow_add_forum() {
        return show_add_forum;
    }

    public void setShow_add_forum(int show_add_forum) {
        this.show_add_forum = show_add_forum;
    }

    public int getStick_total_number() {
        return stick_total_number;
    }

    public void setStick_total_number(int stick_total_number) {
        this.stick_total_number = stick_total_number;
    }

    public boolean isStick_has_more() {
        return stick_has_more;
    }

    public void setStick_has_more(boolean stick_has_more) {
        this.stick_has_more = stick_has_more;
    }

    public TabInfoBean getTab_info() {
        return tab_info;
    }

    public void setTab_info(TabInfoBean tab_info) {
        this.tab_info = tab_info;
    }

    public boolean isStable() {
        return stable;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<?> getStick_comments() {
        return stick_comments;
    }

    public void setStick_comments(List<?> stick_comments) {
        this.stick_comments = stick_comments;
    }

    public static class TabInfoBean {
        /**
         * current_tab_index : 0
         * tabs : ["热度","时间"]
         */

        private int current_tab_index;
        private List<String> tabs;

        public int getCurrent_tab_index() {
            return current_tab_index;
        }

        public void setCurrent_tab_index(int current_tab_index) {
            this.current_tab_index = current_tab_index;
        }

        public List<String> getTabs() {
            return tabs;
        }

        public void setTabs(List<String> tabs) {
            this.tabs = tabs;
        }
    }

    public static class DataBean {
        /**
         * comment : {"id":1591897498741779,"text":"要是我们有中-35就好了。","content_rich_span":"","reply_count":0,"reply_list":[],"digg_count":0,"bury_count":0,"create_time":1518151759,"score":0.34566956758499146,"user_id":7012220657,"user_name":"摇醉红尘","remark_name":"","user_profile_image_url":"http://p0.pstatp.com/origin/3795/3044413937","user_verified":false,"is_following":0,"is_followed":0,"is_blocking":0,"is_blocked":0,"is_pgc_author":0,"author_badge":[],"verified_reason":"","user_bury":0,"user_digg":0,"user_relation":0,"user_auth_info":"","user_decoration":"","media_info":{"name":"","avatar_url":""},"platform":"feifei"}
         * cell_type : 1
         */

        private CommentBean comment;
        private int cell_type;

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public int getCell_type() {
            return cell_type;
        }

        public void setCell_type(int cell_type) {
            this.cell_type = cell_type;
        }

        public static class CommentBean {
            /**
             * id : 1591897498741779
             * text : 要是我们有中-35就好了。
             * content_rich_span :
             * reply_count : 0
             * reply_list : []
             * digg_count : 0
             * bury_count : 0
             * create_time : 1518151759
             * score : 0.34566956758499146
             * user_id : 7012220657
             * user_name : 摇醉红尘
             * remark_name :
             * user_profile_image_url : http://p0.pstatp.com/origin/3795/3044413937
             * user_verified : false
             * is_following : 0
             * is_followed : 0
             * is_blocking : 0
             * is_blocked : 0
             * is_pgc_author : 0
             * author_badge : []
             * verified_reason :
             * user_bury : 0
             * user_digg : 0
             * user_relation : 0
             * user_auth_info :
             * user_decoration :
             * media_info : {"name":"","avatar_url":""}
             * platform : feifei
             */

            private long id;
            private String text;
            private String content_rich_span;
            private int reply_count;
            private int digg_count;
            private int bury_count;
            private int create_time;
            private double score;
            private long user_id;
            private String user_name;
            private String remark_name;
            private String user_profile_image_url;
            private boolean user_verified;
            private int is_following;
            private int is_followed;
            private int is_blocking;
            private int is_blocked;
            private int is_pgc_author;
            private String verified_reason;
            private int user_bury;
            private int user_digg;
            private int user_relation;
            private String user_auth_info;
            private String user_decoration;
            private MediaInfoBean media_info;
            private String platform;
            private List<?> reply_list;
            private List<?> author_badge;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getContent_rich_span() {
                return content_rich_span;
            }

            public void setContent_rich_span(String content_rich_span) {
                this.content_rich_span = content_rich_span;
            }

            public int getReply_count() {
                return reply_count;
            }

            public void setReply_count(int reply_count) {
                this.reply_count = reply_count;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public int getBury_count() {
                return bury_count;
            }

            public void setBury_count(int bury_count) {
                this.bury_count = bury_count;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getRemark_name() {
                return remark_name;
            }

            public void setRemark_name(String remark_name) {
                this.remark_name = remark_name;
            }

            public String getUser_profile_image_url() {
                return user_profile_image_url;
            }

            public void setUser_profile_image_url(String user_profile_image_url) {
                this.user_profile_image_url = user_profile_image_url;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public int getIs_following() {
                return is_following;
            }

            public void setIs_following(int is_following) {
                this.is_following = is_following;
            }

            public int getIs_followed() {
                return is_followed;
            }

            public void setIs_followed(int is_followed) {
                this.is_followed = is_followed;
            }

            public int getIs_blocking() {
                return is_blocking;
            }

            public void setIs_blocking(int is_blocking) {
                this.is_blocking = is_blocking;
            }

            public int getIs_blocked() {
                return is_blocked;
            }

            public void setIs_blocked(int is_blocked) {
                this.is_blocked = is_blocked;
            }

            public int getIs_pgc_author() {
                return is_pgc_author;
            }

            public void setIs_pgc_author(int is_pgc_author) {
                this.is_pgc_author = is_pgc_author;
            }

            public String getVerified_reason() {
                return verified_reason;
            }

            public void setVerified_reason(String verified_reason) {
                this.verified_reason = verified_reason;
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

            public int getUser_relation() {
                return user_relation;
            }

            public void setUser_relation(int user_relation) {
                this.user_relation = user_relation;
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

            public MediaInfoBean getMedia_info() {
                return media_info;
            }

            public void setMedia_info(MediaInfoBean media_info) {
                this.media_info = media_info;
            }

            public String getPlatform() {
                return platform;
            }

            public void setPlatform(String platform) {
                this.platform = platform;
            }

            public List<?> getReply_list() {
                return reply_list;
            }

            public void setReply_list(List<?> reply_list) {
                this.reply_list = reply_list;
            }

            public List<?> getAuthor_badge() {
                return author_badge;
            }

            public void setAuthor_badge(List<?> author_badge) {
                this.author_badge = author_badge;
            }

            public static class MediaInfoBean {
                /**
                 * name :
                 * avatar_url :
                 */

                private String name;
                private String avatar_url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }
            }
        }
    }
}
