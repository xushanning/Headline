package com.xu.headline.bean.response;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class NewsListBean {


    /**
     * ret_code : 0
     * pagebean : {"allPages":10,"contentlist":[{"id":"e045c7281aa6f3f9424f64fe0ed03362","pubDate":"2018-01-26 14:24:20","havePic":true,"channelName":"国内焦点","title":"辽宁公布省十三届人大代表名单 共610人","desc":"　　原标题：辽宁省第十三届人民代表大会代表名单（610人）　　辽宁省人民代表大会常务委员会公告　　第83号　　根据《中华人民共和国全国人民代表大会和地方各级人民代表大会选举法》和《中国人民解放军选举全国人民代表大会和县级以上地方各级人民代表大会代表的办法》的规定....","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/_3pc-fyqzcxf8505386.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/HSF--fyqzcxf8505657.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/BqMN-fyqzcxf8505814.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/2jO--fyqzcxf8506036.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/57XA-fyqzcxf8506178.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/uSkz-fyqzcxf8506290.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/qldS-fyqzcxf8506423.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/a_-C-fyqzcxf8506541.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/0cFp-fyqzcxf8506607.jpg"}],"source":"新浪","channelId":"5572a108b3cdc86cf39001cd","link":"http://news.sina.com.cn/c/nd/2018-01-26/doc-ifyqyqni3284556.shtml","hasAll":true}],"currentPage":1,"allNum":191,"maxResult":20}
     */

    private int ret_code;
    private PagebeanBean pagebean;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public PagebeanBean getPagebean() {
        return pagebean;
    }

    public void setPagebean(PagebeanBean pagebean) {
        this.pagebean = pagebean;
    }

    public static class PagebeanBean {
        /**
         * allPages : 10
         * contentlist : [{"id":"e045c7281aa6f3f9424f64fe0ed03362","pubDate":"2018-01-26 14:24:20","havePic":true,"channelName":"国内焦点","title":"辽宁公布省十三届人大代表名单 共610人","desc":"　　原标题：辽宁省第十三届人民代表大会代表名单（610人）　　辽宁省人民代表大会常务委员会公告　　第83号　　根据《中华人民共和国全国人民代表大会和地方各级人民代表大会选举法》和《中国人民解放军选举全国人民代表大会和县级以上地方各级人民代表大会代表的办法》的规定....","imageurls":[{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/_3pc-fyqzcxf8505386.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/HSF--fyqzcxf8505657.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/BqMN-fyqzcxf8505814.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/2jO--fyqzcxf8506036.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/57XA-fyqzcxf8506178.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/uSkz-fyqzcxf8506290.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/qldS-fyqzcxf8506423.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/a_-C-fyqzcxf8506541.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/0cFp-fyqzcxf8506607.jpg"}],"source":"新浪","channelId":"5572a108b3cdc86cf39001cd","link":"http://news.sina.com.cn/c/nd/2018-01-26/doc-ifyqyqni3284556.shtml","hasAll":true}]
         * currentPage : 1
         * allNum : 191
         * maxResult : 20
         */

        private int allPages;
        private int currentPage;
        private int allNum;
        private int maxResult;
        private List<ContentlistBean> contentlist;

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public List<ContentlistBean> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<ContentlistBean> contentlist) {
            this.contentlist = contentlist;
        }

        public static class ContentlistBean {
            /**
             * id : e045c7281aa6f3f9424f64fe0ed03362
             * pubDate : 2018-01-26 14:24:20
             * havePic : true
             * channelName : 国内焦点
             * title : 辽宁公布省十三届人大代表名单 共610人
             * desc : 　　原标题：辽宁省第十三届人民代表大会代表名单（610人）　　辽宁省人民代表大会常务委员会公告　　第83号　　根据《中华人民共和国全国人民代表大会和地方各级人民代表大会选举法》和《中国人民解放军选举全国人民代表大会和县级以上地方各级人民代表大会代表的办法》的规定....
             * imageurls : [{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/_3pc-fyqzcxf8505386.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/HSF--fyqzcxf8505657.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/BqMN-fyqzcxf8505814.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/2jO--fyqzcxf8506036.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/57XA-fyqzcxf8506178.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/uSkz-fyqzcxf8506290.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/qldS-fyqzcxf8506423.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/a_-C-fyqzcxf8506541.jpg"},{"height":0,"width":0,"url":"http://n.sinaimg.cn/translate/w600h450/20180126/0cFp-fyqzcxf8506607.jpg"}]
             * source : 新浪
             * channelId : 5572a108b3cdc86cf39001cd
             * link : http://news.sina.com.cn/c/nd/2018-01-26/doc-ifyqyqni3284556.shtml
             * hasAll : true
             */

            private String id;
            private String pubDate;
            private boolean havePic;
            private String channelName;
            private String title;
            private String desc;
            private String source;
            private String channelId;
            private String link;
            private boolean hasAll;
            private List<ImageurlsBean> imageurls;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isHavePic() {
                return havePic;
            }

            public void setHavePic(boolean havePic) {
                this.havePic = havePic;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public boolean isHasAll() {
                return hasAll;
            }

            public void setHasAll(boolean hasAll) {
                this.hasAll = hasAll;
            }

            public List<ImageurlsBean> getImageurls() {
                return imageurls;
            }

            public void setImageurls(List<ImageurlsBean> imageurls) {
                this.imageurls = imageurls;
            }

            public static class ImageurlsBean {
                /**
                 * height : 0
                 * width : 0
                 * url : http://n.sinaimg.cn/translate/w600h450/20180126/_3pc-fyqzcxf8505386.jpg
                 */

                private int height;
                private int width;
                private String url;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
