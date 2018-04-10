package com.xu.headline.bean.response;

import java.util.List;

/**
 * Created by xusn10 on 2018/3/6.
 *
 * @author xusn10
 *         评论回复的主评论（主题，被回复的那一条comment）
 */

public class CommentReplyThemeBean {

    /**
     * ban_face : false
     * show_repost_entrance : 1
     * stable : true
     * message : success
     * data : {"status":1,"text":"希望中国社会都能少点浮躁，踏踏实实的搞好实业，这样的发展才是最好。","is_pgc_author":0,"create_time":1519815928,"share_url":"http://weitoutiao.zjurl.cn/ugc/share/comment/1593642506137613/","user_digg":0,"id":1593642506137613,"cell_type":1,"group":{"open_url":"sslocal://detail?groupid=6527517334179938824&item_id=6527517334179938824","item_id":6527517334179938824,"thumb_url":"http://p3.pstatp.com/list/300x300/66bb0003a27ac2839b24","group_id":6527517334179938824,"user_id":3134187068,"title":"比尔·盖茨：AI领域，中国无法撼动美国领先地位","item_type":4,"item_id_str":"6527517334179938824","media_type":1,"group_id_str":"6527517334179938824","user_name":"机器之心"},"user":{"is_followed":0,"description":"","is_following":0,"is_blocked":0,"user_verified":0,"user_auth_info":"","is_blocking":0,"user_id":94043327299,"screen_name":"淋雨的小新","author_badge":[],"user_relation":0,"verified_reason":"","avatar_url":"http://p0.pstatp.com/origin/3793/3131589739","user_decoration":null},"digg_count":768,"content_rich_span":"","content":"希望中国社会都能少点浮躁，踏踏实实的搞好实业，这样的发展才是最好。","comment_count":25,"repost_params":{"opt_id_type":1,"title":"比尔·盖茨：AI领域，中国无法撼动美国领先地位","fw_id_type":4,"fw_id":6527517334179938824,"cover_url":"http://p3.pstatp.com/list/300x300/66bb0003a27ac2839b24","opt_id":1593642506137613,"repost_type":211,"fw_user_id":3134187068,"schema":""},"log_param":{"author_id":3134187068,"group_id":6527517334179938824,"group_source":2},"dongtai_id":1593642506137613,"delete":0}
     * show_repost_weitoutiao_entrance : 1
     */

    private boolean ban_face;
    private int show_repost_entrance;
    private boolean stable;
    private String message;
    private DataBean data;
    private int show_repost_weitoutiao_entrance;

    public boolean isBan_face() {
        return ban_face;
    }

    public void setBan_face(boolean ban_face) {
        this.ban_face = ban_face;
    }

    public int getShow_repost_entrance() {
        return show_repost_entrance;
    }

    public void setShow_repost_entrance(int show_repost_entrance) {
        this.show_repost_entrance = show_repost_entrance;
    }

    public boolean isStable() {
        return stable;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getShow_repost_weitoutiao_entrance() {
        return show_repost_weitoutiao_entrance;
    }

    public void setShow_repost_weitoutiao_entrance(int show_repost_weitoutiao_entrance) {
        this.show_repost_weitoutiao_entrance = show_repost_weitoutiao_entrance;
    }

    public static class DataBean {
        /**
         * status : 1
         * text : 希望中国社会都能少点浮躁，踏踏实实的搞好实业，这样的发展才是最好。
         * is_pgc_author : 0
         * create_time : 1519815928
         * share_url : http://weitoutiao.zjurl.cn/ugc/share/comment/1593642506137613/
         * user_digg : 0
         * id : 1593642506137613
         * cell_type : 1
         * group : {"open_url":"sslocal://detail?groupid=6527517334179938824&item_id=6527517334179938824","item_id":6527517334179938824,"thumb_url":"http://p3.pstatp.com/list/300x300/66bb0003a27ac2839b24","group_id":6527517334179938824,"user_id":3134187068,"title":"比尔·盖茨：AI领域，中国无法撼动美国领先地位","item_type":4,"item_id_str":"6527517334179938824","media_type":1,"group_id_str":"6527517334179938824","user_name":"机器之心"}
         * user : {"is_followed":0,"description":"","is_following":0,"is_blocked":0,"user_verified":0,"user_auth_info":"","is_blocking":0,"user_id":94043327299,"screen_name":"淋雨的小新","author_badge":[],"user_relation":0,"verified_reason":"","avatar_url":"http://p0.pstatp.com/origin/3793/3131589739","user_decoration":null}
         * digg_count : 768
         * content_rich_span :
         * content : 希望中国社会都能少点浮躁，踏踏实实的搞好实业，这样的发展才是最好。
         * comment_count : 25
         * repost_params : {"opt_id_type":1,"title":"比尔·盖茨：AI领域，中国无法撼动美国领先地位","fw_id_type":4,"fw_id":6527517334179938824,"cover_url":"http://p3.pstatp.com/list/300x300/66bb0003a27ac2839b24","opt_id":1593642506137613,"repost_type":211,"fw_user_id":3134187068,"schema":""}
         * log_param : {"author_id":3134187068,"group_id":6527517334179938824,"group_source":2}
         * dongtai_id : 1593642506137613
         * delete : 0
         */

        private int status;
        private String text;
        private int is_pgc_author;
        private int create_time;
        private String share_url;
        private int user_digg;
        private long id;
        private int cell_type;
        private GroupBean group;
        private UserBean user;
        private int digg_count;
        private String content_rich_span;
        private String content;
        private int comment_count;
        private RepostParamsBean repost_params;
        private LogParamBean log_param;
        private long dongtai_id;
        private int delete;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getIs_pgc_author() {
            return is_pgc_author;
        }

        public void setIs_pgc_author(int is_pgc_author) {
            this.is_pgc_author = is_pgc_author;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getUser_digg() {
            return user_digg;
        }

        public void setUser_digg(int user_digg) {
            this.user_digg = user_digg;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getCell_type() {
            return cell_type;
        }

        public void setCell_type(int cell_type) {
            this.cell_type = cell_type;
        }

        public GroupBean getGroup() {
            return group;
        }

        public void setGroup(GroupBean group) {
            this.group = group;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public String getContent_rich_span() {
            return content_rich_span;
        }

        public void setContent_rich_span(String content_rich_span) {
            this.content_rich_span = content_rich_span;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public RepostParamsBean getRepost_params() {
            return repost_params;
        }

        public void setRepost_params(RepostParamsBean repost_params) {
            this.repost_params = repost_params;
        }

        public LogParamBean getLog_param() {
            return log_param;
        }

        public void setLog_param(LogParamBean log_param) {
            this.log_param = log_param;
        }

        public long getDongtai_id() {
            return dongtai_id;
        }

        public void setDongtai_id(long dongtai_id) {
            this.dongtai_id = dongtai_id;
        }

        public int getDelete() {
            return delete;
        }

        public void setDelete(int delete) {
            this.delete = delete;
        }

        public static class GroupBean {
            /**
             * open_url : sslocal://detail?groupid=6527517334179938824&item_id=6527517334179938824
             * item_id : 6527517334179938824
             * thumb_url : http://p3.pstatp.com/list/300x300/66bb0003a27ac2839b24
             * group_id : 6527517334179938824
             * user_id : 3134187068
             * title : 比尔·盖茨：AI领域，中国无法撼动美国领先地位
             * item_type : 4
             * item_id_str : 6527517334179938824
             * media_type : 1
             * group_id_str : 6527517334179938824
             * user_name : 机器之心
             */

            private String open_url;
            private long item_id;
            private String thumb_url;
            private long group_id;
            private long user_id;
            private String title;
            private int item_type;
            private String item_id_str;
            private int media_type;
            private String group_id_str;
            private String user_name;

            public String getOpen_url() {
                return open_url;
            }

            public void setOpen_url(String open_url) {
                this.open_url = open_url;
            }

            public long getItem_id() {
                return item_id;
            }

            public void setItem_id(long item_id) {
                this.item_id = item_id;
            }

            public String getThumb_url() {
                return thumb_url;
            }

            public void setThumb_url(String thumb_url) {
                this.thumb_url = thumb_url;
            }

            public long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getItem_type() {
                return item_type;
            }

            public void setItem_type(int item_type) {
                this.item_type = item_type;
            }

            public String getItem_id_str() {
                return item_id_str;
            }

            public void setItem_id_str(String item_id_str) {
                this.item_id_str = item_id_str;
            }

            public int getMedia_type() {
                return media_type;
            }

            public void setMedia_type(int media_type) {
                this.media_type = media_type;
            }

            public String getGroup_id_str() {
                return group_id_str;
            }

            public void setGroup_id_str(String group_id_str) {
                this.group_id_str = group_id_str;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }
        }

        public static class UserBean {
            /**
             * is_followed : 0
             * description :
             * is_following : 0
             * is_blocked : 0
             * user_verified : 0
             * user_auth_info :
             * is_blocking : 0
             * user_id : 94043327299
             * screen_name : 淋雨的小新
             * author_badge : []
             * user_relation : 0
             * verified_reason :
             * avatar_url : http://p0.pstatp.com/origin/3793/3131589739
             * user_decoration : null
             */

            private int is_followed;
            private String description;
            private int is_following;
            private int is_blocked;
            private int user_verified;
            private String user_auth_info;
            private int is_blocking;
            private long user_id;
            private String screen_name;
            private int user_relation;
            private String verified_reason;
            private String avatar_url;
            private Object user_decoration;
            private List<?> author_badge;

            public int getIs_followed() {
                return is_followed;
            }

            public void setIs_followed(int is_followed) {
                this.is_followed = is_followed;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getIs_following() {
                return is_following;
            }

            public void setIs_following(int is_following) {
                this.is_following = is_following;
            }

            public int getIs_blocked() {
                return is_blocked;
            }

            public void setIs_blocked(int is_blocked) {
                this.is_blocked = is_blocked;
            }

            public int getUser_verified() {
                return user_verified;
            }

            public void setUser_verified(int user_verified) {
                this.user_verified = user_verified;
            }

            public String getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(String user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public int getIs_blocking() {
                return is_blocking;
            }

            public void setIs_blocking(int is_blocking) {
                this.is_blocking = is_blocking;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public int getUser_relation() {
                return user_relation;
            }

            public void setUser_relation(int user_relation) {
                this.user_relation = user_relation;
            }

            public String getVerified_reason() {
                return verified_reason;
            }

            public void setVerified_reason(String verified_reason) {
                this.verified_reason = verified_reason;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public Object getUser_decoration() {
                return user_decoration;
            }

            public void setUser_decoration(Object user_decoration) {
                this.user_decoration = user_decoration;
            }

            public List<?> getAuthor_badge() {
                return author_badge;
            }

            public void setAuthor_badge(List<?> author_badge) {
                this.author_badge = author_badge;
            }
        }

        public static class RepostParamsBean {
            /**
             * opt_id_type : 1
             * title : 比尔·盖茨：AI领域，中国无法撼动美国领先地位
             * fw_id_type : 4
             * fw_id : 6527517334179938824
             * cover_url : http://p3.pstatp.com/list/300x300/66bb0003a27ac2839b24
             * opt_id : 1593642506137613
             * repost_type : 211
             * fw_user_id : 3134187068
             * schema :
             */

            private int opt_id_type;
            private String title;
            private int fw_id_type;
            private long fw_id;
            private String cover_url;
            private long opt_id;
            private int repost_type;
            private long fw_user_id;
            private String schema;

            public int getOpt_id_type() {
                return opt_id_type;
            }

            public void setOpt_id_type(int opt_id_type) {
                this.opt_id_type = opt_id_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getFw_id_type() {
                return fw_id_type;
            }

            public void setFw_id_type(int fw_id_type) {
                this.fw_id_type = fw_id_type;
            }

            public long getFw_id() {
                return fw_id;
            }

            public void setFw_id(long fw_id) {
                this.fw_id = fw_id;
            }

            public String getCover_url() {
                return cover_url;
            }

            public void setCover_url(String cover_url) {
                this.cover_url = cover_url;
            }

            public long getOpt_id() {
                return opt_id;
            }

            public void setOpt_id(long opt_id) {
                this.opt_id = opt_id;
            }

            public int getRepost_type() {
                return repost_type;
            }

            public void setRepost_type(int repost_type) {
                this.repost_type = repost_type;
            }

            public long getFw_user_id() {
                return fw_user_id;
            }

            public void setFw_user_id(long fw_user_id) {
                this.fw_user_id = fw_user_id;
            }

            public String getSchema() {
                return schema;
            }

            public void setSchema(String schema) {
                this.schema = schema;
            }
        }

        public static class LogParamBean {
            /**
             * author_id : 3134187068
             * group_id : 6527517334179938824
             * group_source : 2
             */

            private long author_id;
            private long group_id;
            private int group_source;

            public long getAuthor_id() {
                return author_id;
            }

            public void setAuthor_id(long author_id) {
                this.author_id = author_id;
            }

            public long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public int getGroup_source() {
                return group_source;
            }

            public void setGroup_source(int group_source) {
                this.group_source = group_source;
            }
        }
    }
}
