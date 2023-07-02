package com.example.test_server.model.dto;

import com.example.test_server.util.MapperUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;

    // getters and setters

    public Map<String, Object> toMap() {
        return MapperUtil.convertValue(this, HashMap.class);
    }

}
