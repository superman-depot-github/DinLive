package com.dinlive.din.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.dinlive.din.app.MyAppliction;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SPUtil {
    private static SPUtil util;
    private static SharedPreferences sp;

    private final static String BOOLEAN = "Boolean";
    private final static String LONG = "Long";
    private final static String FLOAT = "Float";
    private final static String STRING = "String";
    private final static String INTEGER = "Integer";

    private static Map<String, SharedPreferences> spMap;

    private SPUtil(Context context, String name) {
        if (spMap == null) {
            spMap = new HashMap();
        }

        if (spMap.containsKey(name)) {
            sp = spMap.get(name);
        } else {
            sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            spMap.put(name, sp);
        }
    }

    public static SPUtil getInstance(String name) {
        if (util == null) {
            return util = new SPUtil(MyAppliction.context, name);
        } else {
            return util;
        }
    }

    public static SPUtil getInstance() {
        if (util == null) {
            return util = new SPUtil(MyAppliction.context, "DinLive");
        } else {
            return util;
        }
    }

    public boolean putData(String key, Object value) {
        boolean result;
        SharedPreferences.Editor editor = sp.edit();
        String type = value.getClass().getSimpleName();
        try {
            switch (type) {
                case BOOLEAN:
                    editor.putBoolean(key, (Boolean) value);
                    break;
                case LONG:
                    editor.putLong(key, (Long) value);
                    break;
                case FLOAT:
                    editor.putFloat(key, (Float) value);
                    break;
                case STRING:
                    editor.putString(key, (String) value);
                    break;
                case INTEGER:
                    editor.putInt(key, (Integer) value);
                    break;
                default:
                    Gson gson = new Gson();
                    String json = gson.toJson(value);
                    editor.putString(key, json);
                    break;
            }
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        editor.apply();
        return result;
    }

    public Object getData(String key, Object defaultValue) {
        Object result;
        String type = defaultValue.getClass().getSimpleName();
        try {
            switch (type) {
                case BOOLEAN:
                    result = sp.getBoolean(key, (Boolean) defaultValue);
                    break;
                case LONG:
                    result = sp.getLong(key, (Long) defaultValue);
                    break;
                case FLOAT:
                    result = sp.getFloat(key, (Float) defaultValue);
                    break;
                case STRING:
                    result = sp.getString(key, (String) defaultValue);
                    break;
                case INTEGER:
                    result = sp.getInt(key, (Integer) defaultValue);
                    break;
                default:
                    Gson gson = new Gson();
                    String json = sp.getString(key, "");
                    if (!json.equals("") && json.length() > 0) {
                        result = gson.fromJson(json, defaultValue.getClass());
                    } else {
                        result = defaultValue;
                    }
                    break;
            }
        } catch (Exception e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }

    public <T> boolean putListData(String key, List<T> list) {
        boolean result;
        String type = list.get(0).getClass().getSimpleName();
        SharedPreferences.Editor editor = sp.edit();
        JsonArray array = new JsonArray();
        try {
            switch (type) {
                case BOOLEAN:
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Boolean) list.get(i));
                    }
                    break;
                case LONG:
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Long) list.get(i));
                    }
                    break;
                case FLOAT:
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Float) list.get(i));
                    }
                    break;
                case STRING:
                    for (int i = 0; i < list.size(); i++) {
                        array.add((String) list.get(i));
                    }
                    break;
                case INTEGER:
                    for (int i = 0; i < list.size(); i++) {
                        array.add((Integer) list.get(i));
                    }
                    break;
                default:
                    Gson gson = new Gson();
                    for (int i = 0; i < list.size(); i++) {
                        JsonElement obj = gson.toJsonTree(list.get(i));
                        array.add(obj);
                    }
                    break;
            }
            editor.putString(key, array.toString());
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        editor.apply();
        return result;
    }

    public <T> List<T> getListData(String key, Class<T> cls) {
        List<T> list = new ArrayList<>();
        String json = sp.getString(key, "");
        if (!json.equals("") && json.length() > 0) {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(json).getAsJsonArray();
            for (JsonElement elem : array) {
                list.add(gson.fromJson(elem, cls));
            }
        }
        return list;
    }

    public <K, V> boolean putHashMapData(String key, Map<K, V> map) {
        boolean result;
        SharedPreferences.Editor editor = sp.edit();
        try {
            Gson gson = new Gson();
            String json = gson.toJson(map);
            editor.putString(key, json);
            result = true;
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        editor.apply();
        return result;
    }

    public <V> HashMap<String, V> getHashMapData(String key, Class<V> clsV) {
        String json = sp.getString(key, "");
        HashMap<String, V> map = new HashMap<>();
        Gson gson = new Gson();
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entrySet = obj.entrySet();
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            String entryKey = entry.getKey();
            JsonObject value = (JsonObject) entry.getValue();
            map.put(entryKey, gson.fromJson(value, clsV));
        }

        return map;
    }
}
