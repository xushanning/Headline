package com.xu.headline.bean;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/5.
 *
 * @author xu
 */

public class NewsSuggestChannelBean {

    /**
     * version : 47840702832|14|1517800347
     * data : [{"category":"nineteenth","web_url":"","flags":0,"name":"新时代","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_hot","web_url":"","flags":0,"name":"热点","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_local","web_url":"","flags":0,"name":"北京","tip_new":0,"default_add":1,"concern_id":"6216118333234743809","type":4,"icon_url":""},{"category":"video","web_url":"","flags":0,"name":"视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"组图","web_url":"","flags":0,"name":"图片","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_entertainment","web_url":"","flags":0,"name":"娱乐","tip_new":0,"default_add":1,"concern_id":"6215497896830175745","type":4,"icon_url":""},{"category":"question_and_answer","web_url":"https://ic.snssdk.com/wenda/v1/waphome/brow/","flags":0,"name":"问答","tip_new":0,"default_add":1,"concern_id":"6260258266329123329","type":4,"icon_url":""},{"category":"news_tech","web_url":"","flags":0,"name":"科技","tip_new":0,"default_add":1,"concern_id":"6215497899594222081","type":4,"icon_url":""},{"category":"news_car","web_url":"","flags":0,"name":"懂车帝","tip_new":0,"default_add":1,"concern_id":"6215497898671475202","type":4,"icon_url":""},{"category":"news_finance","web_url":"","flags":0,"name":"财经","tip_new":0,"default_add":1,"concern_id":"6215497900357585410","type":4,"icon_url":""},{"category":"news_military","web_url":"","flags":0,"name":"军事","tip_new":0,"default_add":1,"concern_id":"6215497895454444033","type":4,"icon_url":""},{"category":"news_sports","web_url":"","flags":0,"name":"体育","tip_new":0,"default_add":1,"concern_id":"6215497726554016258","type":4,"icon_url":""},{"category":"essay_joke","web_url":"","flags":0,"name":"段子","tip_new":0,"default_add":1,"concern_id":"","type":3,"icon_url":""},{"category":"news_world","web_url":"","flags":0,"name":"国际","tip_new":0,"default_add":1,"concern_id":"6215497896255556098","type":4,"icon_url":""},{"category":"image_funny","web_url":"","flags":0,"name":"趣图","tip_new":0,"default_add":1,"concern_id":"","type":1,"icon_url":""},{"category":"news_health","web_url":"","flags":0,"name":"健康","tip_new":0,"default_add":1,"concern_id":"6215497895248923137","type":4,"icon_url":""},{"category":"jinritemai","web_url":"http://temai.snssdk.com/article/channel/index?s_refer=tt_article","flags":1,"name":"特卖","tip_new":0,"default_add":1,"concern_id":"","type":5,"icon_url":""},{"category":"news_house","web_url":"","flags":0,"name":"房产","tip_new":0,"default_add":1,"concern_id":"6215497897127971330","type":4,"icon_url":""}]
     * pre_data : []
     */

    private String version;
    private List<DataBean> data;
    private List<?> pre_data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<?> getPre_data() {
        return pre_data;
    }

    public void setPre_data(List<?> pre_data) {
        this.pre_data = pre_data;
    }

    public static class DataBean {
        /**
         * category : nineteenth
         * web_url :
         * flags : 0
         * name : 新时代
         * tip_new : 0
         * default_add : 1
         * concern_id :
         * type : 4
         * icon_url :
         */

        private String category;
        private String web_url;
        private int flags;
        private String name;
        private int tip_new;
        private int default_add;
        private String concern_id;
        private int type;
        private String icon_url;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getFlags() {
            return flags;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTip_new() {
            return tip_new;
        }

        public void setTip_new(int tip_new) {
            this.tip_new = tip_new;
        }

        public int getDefault_add() {
            return default_add;
        }

        public void setDefault_add(int default_add) {
            this.default_add = default_add;
        }

        public String getConcern_id() {
            return concern_id;
        }

        public void setConcern_id(String concern_id) {
            this.concern_id = concern_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }
    }
}
