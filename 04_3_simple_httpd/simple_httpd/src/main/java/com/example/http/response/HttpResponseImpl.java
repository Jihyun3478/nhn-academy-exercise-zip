package com.example.http.response;

import java.util.Map;

/**
 * 서버의 응답을 저장하고 리다이렉트를 확인하는 클래스
 */
public class HttpResponseImpl implements HttpResponse {
    private int status;
    private Map<String, String> headers;
    private String body;

    public HttpResponseImpl(int status, Map<String, String> headers, String body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getLocation() {
        return headers.getOrDefault("Location", headers.get("location"));
    }
}
