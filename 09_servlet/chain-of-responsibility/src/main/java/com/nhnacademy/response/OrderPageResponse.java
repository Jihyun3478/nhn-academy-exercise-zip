package com.nhnacademy.response;

import com.nhnacademy.member.Member;
import com.nhnacademy.member.Role;
import com.nhnacademy.request.Request;

public class OrderPageResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("=========== OrderPageResponse ===========");
        Member member = (Member) request.get("member");
        System.out.println("아이디: " + member.getId());
        System.out.println("이름: " + member.getName());
        System.out.println("등급: " + Role.MANAGER);
        System.out.println("do something ... MANAGER ...");
    }
}
