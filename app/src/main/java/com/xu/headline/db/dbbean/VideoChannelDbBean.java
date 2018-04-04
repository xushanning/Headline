package com.xu.headline.db.dbbean;

import com.xu.headline.bean.VideoChannelBean;
import com.xu.headline.db.helper.VideoChannelConvert;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 言吾許
 */
@Entity
public class VideoChannelDbBean {
    @Id(autoincrement = true)
    private Long id;
    /**
     * iMei号作为区分的标志
     */
    private String iMei;
    @Convert(columnType = String.class, converter = VideoChannelConvert.class)
    private List<VideoChannelBean> channels;
    /**
     * 获取频道的时间（如果超过24小时，那么重新获取）
     */
    private long time;
    @Generated(hash = 717867207)
    public VideoChannelDbBean(Long id, String iMei, List<VideoChannelBean> channels,
            long time) {
        this.id = id;
        this.iMei = iMei;
        this.channels = channels;
        this.time = time;
    }
    @Generated(hash = 1568404659)
    public VideoChannelDbBean() {
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
    public List<VideoChannelBean> getChannels() {
        return this.channels;
    }
    public void setChannels(List<VideoChannelBean> channels) {
        this.channels = channels;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
