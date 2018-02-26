package com.xu.headline.bean.authorinfo;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by xusn10 on 2018/2/26.
 *
 * @author xu
 */

public class OrderedInfoDeserializer implements JsonDeserializer<BaseOrderedInfoBean> {
    private static final String LABELS = "labels";
    private static final String LIKE_END_REWARDS = "like_and_rewards";
    private static final String AD = "ad";
    private static final String RELATED_NEWS = "related_news";

    @Override
    public BaseOrderedInfoBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        switch (name) {
            case LABELS:
                return new Gson().fromJson(json, OrderedInfoBean1.class);
            case LIKE_END_REWARDS:
                return new Gson().fromJson(json, OrderedInfoBean2.class);
            case AD:
                return new Gson().fromJson(json, OrderedInfoBean3.class);
            case RELATED_NEWS:
                return new Gson().fromJson(json, OrderedInfoBean4.class);
            default:
                return null;
        }
    }
}
