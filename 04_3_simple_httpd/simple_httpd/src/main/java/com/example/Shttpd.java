package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import com.example.http.HttpServer;

public class Shttpd {
//     1. 서버 시작 및 요청 수신
//     ServerSocket을 이용해 특정 포트에서 요청을 수신합니다.
//     Socket을 통해 클라이언트와 통신하며 요청을 읽습니다.

//     2. HTTP 요청 파싱
//     첫 번째 줄에서 method, path, protocol을 추출합니다.
//     GET, POST, DELETE 등을 구분하여 처리합니다.

//     3. GET 요청 처리
//     GET / 요청 시 document-root 디렉토리 목록을 HTML로 반환합니다.
//     GET /file-path 요청 시 파일이 존재하면 200 OK와 함께 응답합니다.
//     파일이 없으면 404 Not Found, 권한이 없으면 403 Forbidden을 반환합니다.

//     4. POST 요청 (파일 업로드)
//     multipart/form-data 여부를 확인합니다.
//     파일 이름을 추출하고 이미 존재하는지 확인 (409 Conflict).
//     저장할 권한이 있는지 확인 (403 Forbidden).
//     정상적으로 저장되면 201 Created 응답.

//     5. DELETE 요청 (파일 삭제)
//     요청된 파일이 존재하는지 확인.
//     삭제 권한이 있는지 확인.
//     삭제 후 204 No Content 반환.

//     6. 응답 생성
//     적절한 Content-Type 설정 (MIME 타입).
//     에러 발생 시 적절한 HTTP 응답 코드 반환.

//     7. Access Log 출력
//     요청 시간, 메서드, 경로, 응답 코드, 크기, 응답 시간 등을 로그로 남깁니다.

    public static void main(String[] args) {
        int port = 80;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        HttpServer httpServer = new HttpServer(port);
        httpServer.start();
    }
}
