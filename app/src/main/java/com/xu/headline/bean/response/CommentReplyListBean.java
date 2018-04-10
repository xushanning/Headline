package com.xu.headline.bean.response;

import java.util.List;

/**
 * Created by xusn10 on 2018/3/6.
 *
 * @author xusn10
 *         评论回复列表
 */

public class CommentReplyListBean {


    private boolean ban_face;
    private String message;
    private DataBeanX data;
    private boolean stable;

    public boolean isBan_face() {
        return ban_face;
    }

    public void setBan_face(boolean ban_face) {
        this.ban_face = ban_face;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public boolean isStable() {
        return stable;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

    public static class DataBeanX {


        private boolean has_more;
        private int total_count;
        private int stick_total_number;
        private int offset;
        private boolean stick_has_more;
        private long group_id;
        private long id;
        private List<CommentsBean> data;
        private List<CommentsBean> hot_comments;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getStick_total_number() {
            return stick_total_number;
        }

        public void setStick_total_number(int stick_total_number) {
            this.stick_total_number = stick_total_number;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isStick_has_more() {
            return stick_has_more;
        }

        public void setStick_has_more(boolean stick_has_more) {
            this.stick_has_more = stick_has_more;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public List<CommentsBean> getData() {
            return data;
        }

        public void setData(List<CommentsBean> data) {
            this.data = data;
        }

        public List<CommentsBean> getHot_comments() {
            return hot_comments;
        }

        public void setHot_comments(List<CommentsBean> hot_comments) {
            this.hot_comments = hot_comments;
        }


        public static class CommentsBean {
            /**
             * content : 你也是一位好老师，为你点赞。
             * create_time : 1520294782
             * is_owner : false
             * user : {"is_followed":null,"is_blocking":null,"is_pgc_author":false,"is_blocked":null,"user_id":5982350850,"name":"手机用户5982350850","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/e58000255077b67ce0e","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"手机用户5982350850"}
             * text : 你也是一位好老师，为你点赞。
             * user_digg : false
             * id : 1594144621784067
             * content_rich_span :
             * digg_count : 41
             */

            private String content;
            private int create_time;
            private boolean is_owner;
            private UserBeanX user;
            private String text;
            private boolean user_digg;
            private long id;
            private String content_rich_span;
            private int digg_count;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public boolean isIs_owner() {
                return is_owner;
            }

            public void setIs_owner(boolean is_owner) {
                this.is_owner = is_owner;
            }

            public UserBeanX getUser() {
                return user;
            }

            public void setUser(UserBeanX user) {
                this.user = user;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public boolean isUser_digg() {
                return user_digg;
            }

            public void setUser_digg(boolean user_digg) {
                this.user_digg = user_digg;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getContent_rich_span() {
                return content_rich_span;
            }

            public void setContent_rich_span(String content_rich_span) {
                this.content_rich_span = content_rich_span;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public static class UserBeanX {
                /**
                 * is_followed : null
                 * is_blocking : null
                 * is_pgc_author : false
                 * is_blocked : null
                 * user_id : 5982350850
                 * name : 手机用户5982350850
                 * author_badge : []
                 * description :
                 * user_relation : 0
                 * verified_reason :
                 * avatar_url : http://p1.pstatp.com/thumb/e58000255077b67ce0e
                 * is_following : null
                 * user_decoration : null
                 * user_auth_info :
                 * user_verified : false
                 * screen_name : 手机用户5982350850
                 */

                private Object is_followed;
                private Object is_blocking;
                private boolean is_pgc_author;
                private Object is_blocked;
                private long user_id;
                private String name;
                private String description;
                private int user_relation;
                private String verified_reason;
                private String avatar_url;
                private Object is_following;
                private Object user_decoration;
                private String user_auth_info;
                private boolean user_verified;
                private String screen_name;
                private List<?> author_badge;

                public Object getIs_followed() {
                    return is_followed;
                }

                public void setIs_followed(Object is_followed) {
                    this.is_followed = is_followed;
                }

                public Object getIs_blocking() {
                    return is_blocking;
                }

                public void setIs_blocking(Object is_blocking) {
                    this.is_blocking = is_blocking;
                }

                public boolean isIs_pgc_author() {
                    return is_pgc_author;
                }

                public void setIs_pgc_author(boolean is_pgc_author) {
                    this.is_pgc_author = is_pgc_author;
                }

                public Object getIs_blocked() {
                    return is_blocked;
                }

                public void setIs_blocked(Object is_blocked) {
                    this.is_blocked = is_blocked;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
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

                public Object getIs_following() {
                    return is_following;
                }

                public void setIs_following(Object is_following) {
                    this.is_following = is_following;
                }

                public Object getUser_decoration() {
                    return user_decoration;
                }

                public void setUser_decoration(Object user_decoration) {
                    this.user_decoration = user_decoration;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public String getScreen_name() {
                    return screen_name;
                }

                public void setScreen_name(String screen_name) {
                    this.screen_name = screen_name;
                }

                public List<?> getAuthor_badge() {
                    return author_badge;
                }

                public void setAuthor_badge(List<?> author_badge) {
                    this.author_badge = author_badge;
                }
            }
        }
    }
}
