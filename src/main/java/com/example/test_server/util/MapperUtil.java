package com.example.test_server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

//@Slf4j
public class MapperUtil {
    static final Logger log = LoggerFactory.getLogger(MapperUtil.class);
    static final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static String writeValueAsString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Exception object : {}", value);
            log.error("Exception", e);
            return null;
        }
    }

    public static byte[] writeValueAsByte(Object value) {
        try {
            return mapper.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            log.error("Exception object : {}", value);
            log.error("Exception", e);
            return null;
        }
    }

    public static <T> T toClass(String json, TypeReference<T> valueTypeRef) {
        try {
            return mapper.readValue(json, valueTypeRef);
        } catch (NullPointerException | IOException var4) {
            log.error("Exception json : {}", json);
            log.error("Exception", var4);
            return null;
        }
    }

    public static <T> T toClass(String json, Class<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (NullPointerException | IOException var4) {
            log.error("Exception json : {}", json);
            log.error("Exception", var4);
            return null;
        }
    }

    public static <T> T toClass(InputStream is, Class<T> valueType) {
        try {
            return mapper.readValue(is, valueType);
        } catch (NullPointerException | IOException var4) {
            log.error("Exception", var4);
            return null;
        }
    }

    public static <T> T toClass(byte[] src, Class<T> valueType) {
        try {
            return mapper.readValue(src, valueType);
        } catch (NullPointerException | IOException var4) {
            log.error("Exception", var4);
            return null;
        }
    }

    public static <T> T toClass(InputStream is, TypeReference<T> valueTypeRef) {
        try {
            return mapper.readValue(is, valueTypeRef);
        } catch (NullPointerException | IOException var4) {
            log.error("Exception", var4);
            return null;
        }
    }

    public static <T> T convertValue(Object object, TypeReference<T> valueTypeRef) {
        try {
            return mapper.convertValue(object, valueTypeRef);
        } catch (Exception var4) {
            log.error("Exception", var4);
            return null;
        }
    }

    public static <T> T convertValue(Object object, Class<T> valueType) {
        try {
            return mapper.convertValue(object, valueType);
        } catch (Exception var4) {
            log.error("Exception", var4);
            return null;
        }
    }

    public static String toString(Object value) {
        try {
            if(value instanceof String) {
                return (String) value;
            }
            return mapper.writeValueAsString(value);
        } catch (NullPointerException | IOException var4) {
            log.error("Exception", var4);
            return null;
        }
    }
}
