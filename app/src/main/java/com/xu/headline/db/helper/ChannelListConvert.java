package com.xu.headline.db.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xu.headline.bean.response.NewsChannelListBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/25.
 * 河道bean和string转换
 *
 * @author xu
 */

public class ChannelListConvert implements PropertyConverter<List<NewsChannelListBean.ChannelBean>, String> {
    private Gson gson = new Gson();

    @Override
    public List<NewsChannelListBean.ChannelBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            return gson.fromJson(databaseValue, new TypeToken<List<NewsChannelListBean.ChannelBean>>() {
            }.getType());
        }
    }

    @Override
    public String convertToDatabaseValue(List<NewsChannelListBean.ChannelBean> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {

            return gson.toJson(entityProperty);
        }
    }


}
