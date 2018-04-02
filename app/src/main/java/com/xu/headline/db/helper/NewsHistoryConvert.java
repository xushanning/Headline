package com.xu.headline.db.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xu.headline.adapter.MultiNewsItem;
import com.xu.headline.bean.NewsSuggestChannelBean;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * @author 言吾許
 *         将新闻历史转化为string
 */

public class NewsHistoryConvert implements PropertyConverter<List<MultiNewsItem>, String> {
    private Gson gson = new Gson();

    @Override
    public List<MultiNewsItem> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            return gson.fromJson(databaseValue, new TypeToken<List<MultiNewsItem>>() {
            }.getType());
        }
    }

    @Override
    public String convertToDatabaseValue(List<MultiNewsItem> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {

            return gson.toJson(entityProperty);
        }
    }
}
