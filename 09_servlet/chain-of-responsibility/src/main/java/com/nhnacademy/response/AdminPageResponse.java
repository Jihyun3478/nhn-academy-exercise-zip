package com.nhnacademy.response;

import com.nhnacademy.member.Member;
import com.nhnacademy.member.Role;
import com.nhnacademy.request.Request;

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
