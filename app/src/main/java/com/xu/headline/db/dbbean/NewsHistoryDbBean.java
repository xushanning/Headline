package com.xu.headline.db.dbbean;

import com.xu.headline.adapter.entity.MultiNewsItem;
import com.xu.headline.db.helper.NewsHistoryConvert;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 言吾許
 *         新闻历史数据bean
 */
@Entity
public class NewsHistoryDbBean {
    @Id(autoincrement = true)
    private Long id;
    /**
     * 频道id
     */
    String channelID;
    /**
     * 刷新时间
     */
    private long time;
    @Convert(columnType = String.class, converter = NewsHistoryConvert.class)
    List<MultiNewsItem> newsItems;

    @Generated(hash = 2070043239)
    public NewsHistoryDbBean(Long id, String channelID, long time,
                             List<MultiNewsItem> newsItems) {
        this.id = id;
        this.channelID = channelID;
        this.time = time;
        this.newsItems = newsItems;
    }

    @Generated(hash = 276076133)
    public NewsHistoryDbBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MultiNewsItem> getNewsItems() {
        return this.newsItems;
    }

    public void setNewsItems(List<MultiNewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public String getChannelID() {
        return this.channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }


}
