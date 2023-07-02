package com.example.test_server.model;

import com.example.test_server.util.M;
import jakarta.ws.rs.core.Response;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseBodyModel {
    protected int status = 200;
    protected String desc = "OK";
    protected Map<String, Object> content;

    public static ResponseBodyModel ok() {
      return new ResponseBodyModel();
    }

    public static ResponseBodyModel status(int status, String desc) {
        return new ResponseBodyModel(status, desc);
    }

    public static ResponseBodyModel status(Response.Status status, String desc) {
        return new ResponseBodyModel(status, desc);
    }

    public static ResponseBodyModel status(Response.Status status) {
        return new ResponseBodyModel(status);
    }

    public ResponseBodyModel() {
        content = M.m();
    }

    public ResponseBodyModel(int status) {
        content = M.m();
    }

    public ResponseBodyModel(int status, String desc) {
        content = M.m();
    }

    public ResponseBodyModel(Response.Status status) {
        content = M.m();
    }

    public ResponseBodyModel(Response.Status status, String desc) {
        content = M.m();
    }

    public ResponseBodyModel addContent(String key, Object value) {
        content.put(key, value);
        return this;
    }

    public ResponseBodyModel addContent(Enum<?> key, Object value) {
        content.put(key.name(), value);
        return this;
    }

    public ResponseBodyModel addContent(Map<String, Object> mapContent) {
        content.putAll(mapContent);
        return this;
    }

    public ResponseBodyModel addContent(Object objContent) {
        Map<String, Object> mapContent = M.fromClass(objContent);
        content.putAll(mapContent);
        return this;
    }

    public ResponseBodyModel addContentNotNull(String key, Object value) {
        if(value != null)
            content.put(key, value);

        return this;
    }
}
