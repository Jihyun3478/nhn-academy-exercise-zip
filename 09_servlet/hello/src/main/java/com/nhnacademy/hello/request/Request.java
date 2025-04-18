package com.nhnacademy.hello.request;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String path;

    private final Map<String, Object> data = new HashMap<>();

    public Request(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }
}
