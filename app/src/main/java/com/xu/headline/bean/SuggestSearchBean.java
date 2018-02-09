package com.xu.headline.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xusn10 on 2018/2/5.
 *
 * @author xu
 */

public class SuggestSearchBean {

    /**
     * call_per_refresh : 2
     * homepage_search_suggest : 爸爸的小棉袄 | 大棚养猪 | 美国总统特朗普
     */
    @SerializedName("call_per_refresh")
    private int callPerRefresh;
    @SerializedName("homepage_search_suggest")
    private String homepageSearchSuggest;

    public int getCallPerRefresh() {
        return callPerRefresh;
    }

    public void setCallPerRefresh(int callPerRefresh) {
        this.callPerRefresh = callPerRefresh;
    }

    public String getHomepageSearchSuggest() {
        return homepageSearchSuggest;
    }

    public void setHomepageSearchSuggest(String homepageSearchSuggest) {
        this.homepageSearchSuggest = homepageSearchSuggest;
    }


}


