package com.xu.headline.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */

public class ChannelsBean {

    /**
     * totalNum : 44
     * ret_code : 0
     * channelList : [{"channelId":"5572a108b3cdc86cf39001cd","name":"国内焦点"},{"channelId":"5572a108b3cdc86cf39001ce","name":"国际焦点"}]
     */

    private int totalNum;
    private int ret_code;
    private List<ChannelListBean> channelList;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
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
        private String name;

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
