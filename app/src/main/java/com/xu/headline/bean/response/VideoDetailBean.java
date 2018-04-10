package com.xu.headline.bean.response;

import java.util.List;

/**
 * 视频详情bean
 * Created by Administrator on 2018/1/24.
 *
 * @author xu
 */

public class VideoDetailBean {


    private int totalPage;
    private String currentPage;
    private String type;
    private List<ItemBean> item;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ItemBean> getItem() {
        return item;
    }

    public void setItem(List<ItemBean> item) {
        this.item = item;
    }

    public static class ItemBean {
        /**
         * documentId : video_966857
         * title : 吴京太有才！一句话就接到新娘伴郎们都笑的岔气了！
         * image : http://d.ifengimg.com/w640_h360_q80/p1.ifengimg.com/a/2018_04/677009d1938e4dc.jpg
         * thumbnail : http://d.ifengimg.com/w640_h360_q80/p1.ifengimg.com/a/2018_04/677009d1938e4dc.jpg
         * guid : f313aa3a-1f64-496d-8201-f4b9baa35832
         * type : phvideo
         * commentsall : 0
         * duration : 22
         * shareUrl : http://share.iclient.ifeng.com/sharenews.f?guid=f313aa3a-1f64-496d-8201-f4b9baa35832
         * commentsUrl : http://share.iclient.ifeng.com/sharenews.f?guid=f313aa3a-1f64-496d-8201-f4b9baa35832
         * video_url : http://ips.ifeng.com/video19.ifeng.com/video09/2018/01/23/19316426-102-009-202822.mp4
         * video_size : 1502
         * praise : 0
         * tread : 1
         * playTime : 8358
         */

        private String documentId;
        private String title;
        private String image;
        private String thumbnail;
        private String guid;
        private String type;
        private int commentsall;
        private int duration;
        private String shareUrl;
        private String commentsUrl;
        private String video_url;
        private int video_size;
        private String praise;
        private String tread;
        private String playTime;

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getCommentsall() {
            return commentsall;
        }

        public void setCommentsall(int commentsall) {
            this.commentsall = commentsall;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getCommentsUrl() {
            return commentsUrl;
        }

        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getVideo_size() {
            return video_size;
        }

        public void setVideo_size(int video_size) {
            this.video_size = video_size;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public String getTread() {
            return tread;
        }

        public void setTread(String tread) {
            this.tread = tread;
        }

        public String getPlayTime() {
            return playTime;
        }

        public void setPlayTime(String playTime) {
            this.playTime = playTime;
        }
    }
}
