package com.xu.headline.bean.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xu.headline.bean.ChannelBean;
import com.xu.headline.bean.ShowApiChannelListBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/25.
 * 河道bean和string转换
 *
 * @author xu
 */

public class ChannelListConvert implements PropertyConverter<List<ShowApiChannelListBean.ChannelListBean>, String> {
    private Gson gson = new Gson();

    @Override
    public List<ShowApiChannelListBean.ChannelListBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            return gson.fromJson(databaseValue, new TypeToken<List<ShowApiChannelListBean.ChannelListBean>>() {
            }.getType());
        }
    }

    @Override
    public String convertToDatabaseValue(List<ShowApiChannelListBean.ChannelListBean> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {

            return gson.toJson(entityProperty);
        }
    }


}
