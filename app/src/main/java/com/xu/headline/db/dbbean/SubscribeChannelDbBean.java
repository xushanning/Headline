package com.xu.headline.db.dbbean;

import com.xu.headline.bean.response.NewsChannelListBean;
import com.xu.headline.db.helper.ChannelListConvert;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

/**
 * 数据库订阅bean
 * Created by xusn10 on 2018/1/25.
 *
 * @author xu
 */
@Entity
public class SubscribeChannelDbBean {
    @Id(autoincrement = true)
    private Long id;
    /**
     * iMei号作为区分的标志
     */
    private String iMei;
    @Convert(columnType = String.class, converter = ChannelListConvert.class)
    private List<NewsChannelListBean.ChannelBean> channels;
    /**
     * 获取频道的时间（如果超过24小时，那么重新获取）
     */
    private long time;
    @Generated(hash = 681923920)
    public SubscribeChannelDbBean(Long id, String iMei,
            List<NewsChannelListBean.ChannelBean> channels, long time) {
        this.id = id;
        this.iMei = iMei;
        this.channels = channels;
        this.time = time;
    }
    @Generated(hash = 764994389)
    public SubscribeChannelDbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIMei() {
        return this.iMei;
    }
    public void setIMei(String iMei) {
        this.iMei = iMei;
    }
    public List<NewsChannelListBean.ChannelBean> getChannels() {
        return this.channels;
    }
    public void setChannels(List<NewsChannelListBean.ChannelBean> channels) {
        this.channels = channels;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }
 

}
