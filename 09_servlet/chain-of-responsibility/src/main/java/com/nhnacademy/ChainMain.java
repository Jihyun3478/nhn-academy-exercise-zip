package com.nhnacademy;

import com.nhnacademy.member.Member;
import com.nhnacademy.request.HttpRequest;
import com.nhnacademy.request.Request;

public class ChainMain {
    public static void main( String[] args ) {
        Request myPageRequest = new Request("/mypage");
        myPageRequest.put("member", Member.createUser("marco", "마르코", "1234"));

        Request adminPageRequest = new Request("/admin");
        adminPageRequest.put("member", Member.createAdmin("admin", "관리자", "1234"));

        Request orderPageRequest = new Request("/order");
        orderPageRequest.put("member", Member.createManager("manager", "매니저", "1234"));

        Request mainPageRequest = new Request("/main");

        System.out.println("=========== /mypage 요청 ===========");
        HttpRequest httpRequest1 = new HttpRequest();
        httpRequest1.doRequest(myPageRequest);

        System.out.println("=========== /admin 요청 ===========");
        HttpRequest httpRequest2 = new HttpRequest();
        httpRequest2.doRequest(adminPageRequest);

        System.out.println("=========== /order 요청 ===========");
        HttpRequest httpRequest3 = new HttpRequest();
        httpRequest3.doRequest(orderPageRequest);

        System.out.println("=========== /main 요청 ===========");
        HttpRequest httpRequest4 = new HttpRequest();
        httpRequest4.doRequest(mainPageRequest);
    }
}
