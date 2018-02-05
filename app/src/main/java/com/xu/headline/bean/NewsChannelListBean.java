package com.xu.headline.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25.
 * @author xu
 */

public class NewsChannelListBean {

    /**
     * totalNum : 44
     * ret_code : 0
     * channelList : [{"channelId":"5572a108b3cdc86cf39001cd","name":"国内焦点"}]
     */

    private int totalNum;
    @SerializedName("ret_code")
    private int retCode;
    private List<ChannelListBean> channelList;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public List<ChannelListBean> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<ChannelListBean> channelList) {
        this.channelList = channelList;
    }

    public static class ChannelListBean {
        /**
         * channelId : 5572a108b3cdc86cf39001cd
         * name : 国内焦点
         */

        private String channelId;
        @SerializedName("name")
        private String channelName;

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }
    }
}
