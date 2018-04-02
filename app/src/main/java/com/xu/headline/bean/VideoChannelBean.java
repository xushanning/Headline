package com.xu.headline.bean;

/**
 * 视频频道bean
 * Created by Administrator on 2018/1/24.
 *
 * @author
 */

public class VideoChannelBean {


    /**
     * category : subv_voice
     * category_type : 0
     * web_url :
     * flags : 0
     * name : 音乐
     * tip_new : 0
     * icon_url :
     * type : 4
     */

    private String category;
    private int category_type;
    private String web_url;
    private int flags;
    private String name;
    private int tip_new;
    private String icon_url;
    private int type;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory_type() {
        return category_type;
    }

    public void setCategory_type(int category_type) {
        this.category_type = category_type;
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

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
