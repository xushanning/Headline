package com.xu.headline.db.dbbean;

import com.xu.headline.bean.ShowApiChannelListBean;
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
    private String iMei;
    @Convert(columnType = String.class, converter = ChannelListConvert.class)
    private List<ShowApiChannelListBean.ChannelListBean> channels;
    @Generated(hash = 1730410447)
    public SubscribeChannelDbBean(Long id, String iMei,
            List<ShowApiChannelListBean.ChannelListBean> channels) {
        this.id = id;
        this.iMei = iMei;
        this.channels = channels;
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
    public List<ShowApiChannelListBean.ChannelListBean> getChannels() {
        return this.channels;
    }
    public void setChannels(List<ShowApiChannelListBean.ChannelListBean> channels) {
        this.channels = channels;
    }

   

}
