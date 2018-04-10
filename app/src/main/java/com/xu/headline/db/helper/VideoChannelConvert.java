package com.xu.headline.db.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xu.headline.bean.response.VideoChannelBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/25.
 * 河道bean和string转换
 *
 * @author xu
 */

public class VideoChannelConvert implements PropertyConverter<List<VideoChannelBean>, String> {
    private Gson gson = new Gson();

    @Override
    public List<VideoChannelBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            return gson.fromJson(databaseValue, new TypeToken<List<VideoChannelBean>>() {
            }.getType());
        }
    }

    @Override
    public String convertToDatabaseValue(List<VideoChannelBean> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            return gson.toJson(entityProperty);
        }
    }


}
