package com.nhnacademy.response;

import com.nhnacademy.request.Request;

public class NotFoundResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("=========== NotFoundResponse ===========");
        System.out.println("존재하지 않는 페이지입니다!");
    }
}
