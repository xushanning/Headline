package com.xu.headline.bean.authorinfo;

/**
 * Created by xusn10 on 2018/2/24.
 *
 * @author xu
 */

public class OrderedInfoBean3 extends BaseOrderedInfoBean {


    /**
     * ad_data : {"image":{"filter_words":[{"id":"4:2","is_selected":false,"name":"看过了"}],"id":4669003274,"image":"http://p1.pstatp.com/origin/61f700051a4b3d4cb339","image_height":238,"image_width":690,"label":"广告","log_extra":"{\"ad_price\":\"WpEhPAAcFu5akSE8ABwW7o-D2UpntQAKFJ4Mig\",\"convert_component_suspend\":0,\"convert_id\":0,\"external_action\":0,\"item_id\":6525910609031070216,\"media_id\":4492956276,\"req_id\":\"20180224162428010010023222209F57\",\"rit\":3}","open_url":"snssdk143://detail?groupid=6413611747302703361\u0026ad_id=4669003274","show_dislike":1,"track_url":"","track_url_list":[],"type":"web","web_title":"","web_url":"https://w.benbun.com/baidu/xiechunlian/index3.html"},"is_preview":false}
     * name : ad
     */

    private String ad_data;
    private String name;

    public String getAd_data() {
        return ad_data;
    }

    public void setAd_data(String ad_data) {
        this.ad_data = ad_data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
