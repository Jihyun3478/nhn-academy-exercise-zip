package com.example.http.request;

import java.util.Map;

public interface HttpRequest {
    String getMethod();

    void setMethod(String optionValue);

    String getHost();

    String getPath();

    Map<String, String> getHeaders();

    String getBody();

    void addHeader(String key, String value);

    void addBody(String body);
}
