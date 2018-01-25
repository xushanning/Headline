package com.xu.headline.db.dbbean;

import com.xu.headline.bean.ChannelBean;
import com.xu.headline.bean.helper.ChannelListConvert;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

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
    private List<ChannelBean> channels;
    @Generated(hash = 417320697)
    public SubscribeChannelDbBean(Long id, String iMei,
            List<ChannelBean> channels) {
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
    public List<ChannelBean> getChannels() {
        return this.channels;
    }
    public void setChannels(List<ChannelBean> channels) {
        this.channels = channels;
    }
   

}
