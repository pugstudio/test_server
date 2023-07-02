package com.example.test_server.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class M {
    public static Map<String, Object> fromClass(Object obj) {
        if (obj == null) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return (Map)mapper.convertValue(obj, JsonUtil.TYPE_MAP_STRING_OBJ);
        }
    }

    public static <K, V> Map<K, V> m() {
        return new HashMap();
    }
}
