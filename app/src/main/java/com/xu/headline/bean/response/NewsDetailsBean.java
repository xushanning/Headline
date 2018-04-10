package com.xu.headline.bean.response;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/9.
 *
 * @author xu
 */

public class NewsDetailsBean {

    /**
     * media_user_id : 5954781019
     * webp_image_detail : [{"url":"http://p9.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp","width":345,"url_list":[{"url":"http://p9.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp"},{"url":"http://pb3.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp"}],"uri":"details/v0/w640/61480005ec89917f81f0.webp","height":238}]
     * content : 详情
     * image_detail : [{"url":"http://p9.pstatp.com/large/61480005ec89917f81f0","width":345,"url_list":[{"url":"http://p9.pstatp.com/large/61480005ec89917f81f0"},{"url":"http://pb1.pstatp.com/large/61480005ec89917f81f0"},{"url":"http://pb3.pstatp.com/large/61480005ec89917f81f0"}],"uri":"large/61480005ec89917f81f0","height":238}]
     * h5_extra : {"publish_time":"02-09 00:28","is_original":false,"str_item_id":"6520252128861094413","title":"韩\u201c坚果风波\u201d豪门女陪跑冬奥火炬传递 受害者却遭降职扫厕所","media":{"praise_data":{},"description":"环球资讯 全球动态 让你的头条更精彩","pgc_custom_menu":"","can_be_praised":false,"name":"环球网","creator_id":5954781019,"avatar_url":"http://p1.pstatp.com/large/4d00054b126ceaf920","v":false,"id":5954781019,"auth_info":"环球网官方帐号","show_pgc_component":true,"user_verified":true,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"环球网官方帐号\"}"},"media_user_id":"5954781019","src_link":"https://m.huanqiu.com/r/MV8wXzExNTk1Mzc2XzEzOF8xNTE4MTA3Mjgw","source":"环球网","publish_stamp":"1518107280","str_group_id":"6520252128861094413"}
     * webp_thumb_image : [{"url":"http://p9.pstatp.com/thumb/61480005ec89917f81f0.webp","width":345,"url_list":[{"url":"http://p9.pstatp.com/thumb/61480005ec89917f81f0.webp"},{"url":"http://pb1.pstatp.com/thumb/61480005ec89917f81f0.webp"},{"url":"http://pb3.pstatp.com/thumb/61480005ec89917f81f0.webp"}],"uri":"thumb//61480005ec89917f81f0.webp","height":238}]
     * item_id : 6520252128861094413
     * is_wenda : 0
     * group_id : 6520252128861094413
     * thumb_image : [{"url":"http://p9.pstatp.com/thumb/61480005ec89917f81f0","width":345,"url_list":[{"url":"http://p9.pstatp.com/thumb/61480005ec89917f81f0"},{"url":"http://pb1.pstatp.com/thumb/61480005ec89917f81f0"},{"url":"http://pb3.pstatp.com/thumb/61480005ec89917f81f0"}],"uri":"thumb/61480005ec89917f81f0","height":238}]
     * aggr_type : 1
     */

    private long media_user_id;
    private String content;
    private H5ExtraBean h5_extra;
    private long item_id;
    private int is_wenda;
    private long group_id;
    private int aggr_type;
    private List<WebpImageDetailBean> webp_image_detail;
    private List<ImageDetailBean> image_detail;
    private List<WebpThumbImageBean> webp_thumb_image;
    private List<ThumbImageBean> thumb_image;

    public long getMedia_user_id() {
        return media_user_id;
    }

    public void setMedia_user_id(long media_user_id) {
        this.media_user_id = media_user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public H5ExtraBean getH5_extra() {
        return h5_extra;
    }

    public void setH5_extra(H5ExtraBean h5_extra) {
        this.h5_extra = h5_extra;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getIs_wenda() {
        return is_wenda;
    }

    public void setIs_wenda(int is_wenda) {
        this.is_wenda = is_wenda;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public List<WebpImageDetailBean> getWebp_image_detail() {
        return webp_image_detail;
    }

    public void setWebp_image_detail(List<WebpImageDetailBean> webp_image_detail) {
        this.webp_image_detail = webp_image_detail;
    }

    public List<ImageDetailBean> getImage_detail() {
        return image_detail;
    }

    public void setImage_detail(List<ImageDetailBean> image_detail) {
        this.image_detail = image_detail;
    }

    public List<WebpThumbImageBean> getWebp_thumb_image() {
        return webp_thumb_image;
    }

    public void setWebp_thumb_image(List<WebpThumbImageBean> webp_thumb_image) {
        this.webp_thumb_image = webp_thumb_image;
    }

    public List<ThumbImageBean> getThumb_image() {
        return thumb_image;
    }

    public void setThumb_image(List<ThumbImageBean> thumb_image) {
        this.thumb_image = thumb_image;
    }

    public static class H5ExtraBean {
        /**
         * publish_time : 02-09 00:28
         * is_original : false
         * str_item_id : 6520252128861094413
         * title : 韩“坚果风波”豪门女陪跑冬奥火炬传递 受害者却遭降职扫厕所
         * media : {"praise_data":{},"description":"环球资讯 全球动态 让你的头条更精彩","pgc_custom_menu":"","can_be_praised":false,"name":"环球网","creator_id":5954781019,"avatar_url":"http://p1.pstatp.com/large/4d00054b126ceaf920","v":false,"id":5954781019,"auth_info":"环球网官方帐号","show_pgc_component":true,"user_verified":true,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"环球网官方帐号\"}"}
         * media_user_id : 5954781019
         * src_link : https://m.huanqiu.com/r/MV8wXzExNTk1Mzc2XzEzOF8xNTE4MTA3Mjgw
         * source : 环球网
         * publish_stamp : 1518107280
         * str_group_id : 6520252128861094413
         */

        private String publish_time;
        private boolean is_original;
        private String str_item_id;
        private String title;
        private MediaBean media;
        private String media_user_id;
        private String src_link;
        private String source;
        private String publish_stamp;
        private String str_group_id;

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public boolean isIs_original() {
            return is_original;
        }

        public void setIs_original(boolean is_original) {
            this.is_original = is_original;
        }

        public String getStr_item_id() {
            return str_item_id;
        }

        public void setStr_item_id(String str_item_id) {
            this.str_item_id = str_item_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public MediaBean getMedia() {
            return media;
        }

        public void setMedia(MediaBean media) {
            this.media = media;
        }

        public String getMedia_user_id() {
            return media_user_id;
        }

        public void setMedia_user_id(String media_user_id) {
            this.media_user_id = media_user_id;
        }

        public String getSrc_link() {
            return src_link;
        }

        public void setSrc_link(String src_link) {
            this.src_link = src_link;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPublish_stamp() {
            return publish_stamp;
        }

        public void setPublish_stamp(String publish_stamp) {
            this.publish_stamp = publish_stamp;
        }

        public String getStr_group_id() {
            return str_group_id;
        }

        public void setStr_group_id(String str_group_id) {
            this.str_group_id = str_group_id;
        }

        public static class MediaBean {
            /**
             * praise_data : {}
             * description : 环球资讯 全球动态 让你的头条更精彩
             * pgc_custom_menu :
             * can_be_praised : false
             * name : 环球网
             * creator_id : 5954781019
             * avatar_url : http://p1.pstatp.com/large/4d00054b126ceaf920
             * v : false
             * id : 5954781019
             * auth_info : 环球网官方帐号
             * show_pgc_component : true
             * user_verified : true
             * user_auth_info : {"auth_type": "0", "auth_info": "环球网官方帐号"}
             */

            private PraiseDataBean praise_data;
            private String description;
            private String pgc_custom_menu;
            private boolean can_be_praised;
            private String name;
            private long creator_id;
            private String avatar_url;
            private boolean v;
            private long id;
            private String auth_info;
            private boolean show_pgc_component;
            private boolean user_verified;
            private String user_auth_info;

            public PraiseDataBean getPraise_data() {
                return praise_data;
            }

            public void setPraise_data(PraiseDataBean praise_data) {
                this.praise_data = praise_data;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPgc_custom_menu() {
                return pgc_custom_menu;
            }

            public void setPgc_custom_menu(String pgc_custom_menu) {
                this.pgc_custom_menu = pgc_custom_menu;
            }

            public boolean isCan_be_praised() {
                return can_be_praised;
            }

            public void setCan_be_praised(boolean can_be_praised) {
                this.can_be_praised = can_be_praised;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getCreator_id() {
                return creator_id;
            }

            public void setCreator_id(long creator_id) {
                this.creator_id = creator_id;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public boolean isV() {
                return v;
            }

            public void setV(boolean v) {
                this.v = v;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getAuth_info() {
                return auth_info;
            }

            public void setAuth_info(String auth_info) {
                this.auth_info = auth_info;
            }

            public boolean isShow_pgc_component() {
                return show_pgc_component;
            }

            public void setShow_pgc_component(boolean show_pgc_component) {
                this.show_pgc_component = show_pgc_component;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public String getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(String user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public static class PraiseDataBean {
            }
        }
    }

    public static class WebpImageDetailBean {
        /**
         * url : http://p9.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp
         * width : 345
         * url_list : [{"url":"http://p9.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp"},{"url":"http://pb3.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp"}]
         * uri : details/v0/w640/61480005ec89917f81f0.webp
         * height : 238
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBean> url_list;

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean {
            /**
             * url : http://p9.pstatp.com/details/v0/w640/61480005ec89917f81f0.webp
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

    public static class ImageDetailBean {
        /**
         * url : http://p9.pstatp.com/large/61480005ec89917f81f0
         * width : 345
         * url_list : [{"url":"http://p9.pstatp.com/large/61480005ec89917f81f0"},{"url":"http://pb1.pstatp.com/large/61480005ec89917f81f0"},{"url":"http://pb3.pstatp.com/large/61480005ec89917f81f0"}]
         * uri : large/61480005ec89917f81f0
         * height : 238
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBeanX> url_list;

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p9.pstatp.com/large/61480005ec89917f81f0
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

    public static class WebpThumbImageBean {
        /**
         * url : http://p9.pstatp.com/thumb/61480005ec89917f81f0.webp
         * width : 345
         * url_list : [{"url":"http://p9.pstatp.com/thumb/61480005ec89917f81f0.webp"},{"url":"http://pb1.pstatp.com/thumb/61480005ec89917f81f0.webp"},{"url":"http://pb3.pstatp.com/thumb/61480005ec89917f81f0.webp"}]
         * uri : thumb//61480005ec89917f81f0.webp
         * height : 238
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBeanXX> url_list;

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBeanXX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanXX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanXX {
            /**
             * url : http://p9.pstatp.com/thumb/61480005ec89917f81f0.webp
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

    public static class ThumbImageBean {
        /**
         * url : http://p9.pstatp.com/thumb/61480005ec89917f81f0
         * width : 345
         * url_list : [{"url":"http://p9.pstatp.com/thumb/61480005ec89917f81f0"},{"url":"http://pb1.pstatp.com/thumb/61480005ec89917f81f0"},{"url":"http://pb3.pstatp.com/thumb/61480005ec89917f81f0"}]
         * uri : thumb/61480005ec89917f81f0
         * height : 238
         */

        private String url;
        private int width;
        private String uri;
        private int height;
        private List<UrlListBeanXXX> url_list;

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

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public List<UrlListBeanXXX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanXXX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanXXX {
            /**
             * url : http://p9.pstatp.com/thumb/61480005ec89917f81f0
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
