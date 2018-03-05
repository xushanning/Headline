package com.xu.headline.bean.authorinfo;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by xusn10 on 2018/2/26.
 *
 * @author xu
 */

public class OrderedInfoDeserializer implements JsonDeserializer<BaseOrderedInfoBean> {
    public static final String LABELS = "labels";
    public static final String LIKE_END_REWARDS = "like_and_rewards";
    public static final String AD = "ad";
    public static final String RELATED_NEWS = "related_news";
    public static final String ALERT_TEXT = "alert_text";

    @Override
    public BaseOrderedInfoBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        Type type;
        switch (name) {
            case LABELS:
                type = new TypeToken<BaseOrderedInfoBean<List<OrderedInfoBean1>>>() {
                }.getType();
                return new Gson().fromJson(json, type);
            case LIKE_END_REWARDS:
                type = new TypeToken<BaseOrderedInfoBean<OrderedInfoBean2>>() {
                }.getType();
                return new Gson().fromJson(json, type);
            case AD:
                type = new TypeToken<BaseOrderedInfoBean<OrderedInfoBean3>>() {
                }.getType();
                return new Gson().fromJson(json, type);
            case RELATED_NEWS:
                type = new TypeToken<BaseOrderedInfoBean<List<OrderedInfoBean4>>>() {
                }.getType();
                return new Gson().fromJson(json, type);
            case ALERT_TEXT:
                type = new TypeToken<BaseOrderedInfoBean<String>>() {
                }.getType();
                return new Gson().fromJson(json, type);
            default:
                return null;
        }
    }
}
