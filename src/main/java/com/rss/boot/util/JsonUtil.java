package com.rss.boot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date:
 * @Modified By:
 */
public class JsonUtil {

    public JsonUtil() {
    }

    public static final <T> T fromJson(String jsonData, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonData, clazz);
    }

    public static final <T> List<T> fromJsonArray(String jsonData, Class<T> clazz) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(jsonData);
        JsonArray jsonArray = el.getAsJsonArray();
        Iterator<JsonElement> it = jsonArray.iterator();
        ArrayList list = new ArrayList();

        while (it.hasNext()) {
            JsonElement je = (JsonElement) it.next();
            list.add(gson.fromJson(je, clazz));
        }

        return list;
    }

    public static final String toJson(Object object, boolean pretty) {
        GsonBuilder gb = new GsonBuilder();
        if (pretty) {
            gb.setPrettyPrinting();
        }

        gb.disableHtmlEscaping();
        Gson gson = gb.create();
        return gson.toJson(object);
    }

    /**
     * fastjson格式化json为实体类
     *
     * @param jsonData
     * @param clazz
     * @param <T>
     * @return
     */
    public static final <T> T fromJsonByFastjson(String jsonData, Class<T> clazz) {
        JSONObject userJson = JSONObject.parseObject(jsonData);
        return (T) JSON.toJavaObject(userJson, clazz);
    }

    /**
     * fastjson格式化实体类
     *
     * @param object
     * @return
     */
    public static final String toJsonByFastjson(Object object) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(object);
        return jsonObject.toJSONString();
    }

}
