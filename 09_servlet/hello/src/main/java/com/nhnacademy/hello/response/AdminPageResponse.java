package com.nhnacademy.hello.response;

import com.nhnacademy.hello.domain.Member;
import com.nhnacademy.hello.domain.Role;
import com.nhnacademy.hello.request.Request;

public class AdminPageResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("=========== AdminPageResponse ===========");
        Member member = (Member) request.get("member");
        System.out.println("아이디: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("등급: " + Role.ADMIN);
        System.out.println("이메일: marco@nhnacademy.com");
        System.out.println("do something ... ADMIN ...");
    }
}
