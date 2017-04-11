package com.leo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.util.Date;

/**
 * Created by niushw on 2016/9/28.
 */
public class JSONUtil {

    public static <T> T jsonToObject(String jsonString, Class<T> cls) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class
                , (JsonDeserializer<Date>) (json, typeOfT, context)
                        -> json == null ? null : new Date(json.getAsLong()))
                .create();

        T responseModel = gson.fromJson(jsonString, cls);
        return responseModel;
    }

    public static <T> String toJSONString(T object) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class
                , (JsonDeserializer<Date>) (json, typeOfT, context)
                        -> json == null ? null : new Date(json.getAsLong()))
                .create();

        String json = gson.toJson(object);
        return json;
    }

    public static void main(String[] args) {
    }
}
