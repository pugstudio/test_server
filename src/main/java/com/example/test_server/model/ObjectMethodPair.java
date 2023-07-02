package com.example.test_server.model;

import lombok.Data;

import java.lang.reflect.Method;

@Data
public class ObjectMethodPair {
    Object first;
    Method second;

    public ObjectMethodPair(Object first, Method second) {
        this.first = first;
        this.second = second;
    }
}
