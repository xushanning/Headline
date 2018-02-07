package com.xu.headline.db.dbbean;

import com.xu.headline.bean.NewsChannelListBean;
import com.xu.headline.bean.NewsSuggestChannelBean;
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
    private List<NewsSuggestChannelBean.DataBean> channels;
    @Generated(hash = 253204302)
    public SubscribeChannelDbBean(Long id, String iMei,
            List<NewsSuggestChannelBean.DataBean> channels) {
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
    public List<NewsSuggestChannelBean.DataBean> getChannels() {
        return this.channels;
    }
    public void setChannels(List<NewsSuggestChannelBean.DataBean> channels) {
        this.channels = channels;
    }
}
