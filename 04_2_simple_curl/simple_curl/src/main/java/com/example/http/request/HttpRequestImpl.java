package com.example.http.request;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 클라이언트의 요청을 생성 및 관리하는 클래스
 */
public class HttpRequestImpl implements HttpRequest {
    // start line
    private String method;

    private String url;
    private String host;
    private String path;

    // headers
    private Map<String,String> headers;

    // body
    private String body;

    public HttpRequestImpl(String method, String url) throws MalformedURLException {
        this.method = method;
        this.url = url;
        this.host = new URL(url).getHost();
        this.path = new URL(url).getPath();
        this.headers = new HashMap<>();
        this.body = "";
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public void setMethod(String optionValue) {
        this.method = optionValue;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    @Override
    public void addBody(String body) {
        this.body += body;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

