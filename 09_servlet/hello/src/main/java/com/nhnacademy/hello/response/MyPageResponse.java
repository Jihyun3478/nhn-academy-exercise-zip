package com.nhnacademy.hello.response;

import com.nhnacademy.hello.domain.Member;
import com.nhnacademy.hello.domain.Role;
import com.nhnacademy.hello.request.Request;

public class MyPageResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("=========== MyPageResponse ===========");
        Member member = (Member) request.get("member");
        System.out.println("아이디: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("등급: " + Role.USER);
        System.out.println("주소: 경남 김해시 내외동 정우빌딩 5층 NHN아카데미");
        System.out.println("do something ... USER ...");
    }
}
