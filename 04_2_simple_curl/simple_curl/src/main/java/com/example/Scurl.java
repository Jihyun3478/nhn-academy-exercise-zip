package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.example.http.HttpClient;
import com.example.http.RedirectHandler;
import com.example.http.request.HttpRequest;
import com.example.http.request.HttpRequestImpl;

public class Scurl {
    public static void main(String[] args) {
        // $ mvn exec:java -Dexec.mainClass="com.nhnacademy.Main" -Dexec.args=""
        /* 02 */ // args = new String[] {"http://httpbin.org/get"};
        /* 03 */ // args = new String[] {"-X", "GET", "http://httpbin.org/get"};
        /* 04 */ // args = new String[] {"-v", "-X", "GET", "http://httpbin.org/get"};
        /* 05 */ // args = new String[] {"-v", "-H", "X-Custom-Header: NA", "http://httpbin.org/get"};
        /* 06 */ // args = new String[] {"-v", "-d", "{\"hello\": \"world\"}", "-H", "Content-Type: application/json", "http://httpbin.org/post"};
        /* 07 */ // args = new String[] {"-v", "-L", "http://httpbin.org/status/302"};
        /* 08 */  args = new String[] {"-F", "upload=@/Users/jihyun/Desktop/취업/대외활동/부트캠프/NHN_아카데미/과제/04_2_simple_curl/simple_curl/src/main/resources/welcome.html", "http://httpbin.org/post"};

        Options options = new Options();
        options.addOption("v", null, false, "verbose, 요청, 응답 헤더를 출력한다.");
        options.addOption("H", null, true, "임의의 헤더를 서버로 전송한다.");
        options.addOption("d", null, true, "POST, PUT 등에 데이터를 전송한다.");
        options.addOption("X", null, true, "사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET");
        options.addOption("L", null, false, "서버의 응답이 30x 계열이면 다음 응답을 따라 간다.");
        options.addOption("F", null, true, "multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.");

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            String[] getArgs = cmd.getArgs();
            if (getArgs.length == 0) {
                throw new IllegalArgumentException("URL을 입력해야 합니다.");
            }
            String urlString = getArgs[0];
            URL url = new URL(urlString);

            String host = url.getHost(); // httpbin.org
            String path = url.getPath(); // /post

            String method = "";
            if (urlString.contains("post")) {
                method = "POST";
            } else {
                method = "GET";
            }

            HttpRequest httpRequest = new HttpRequestImpl(method, urlString);
            HttpClient.sendRequest(cmd, httpRequest);
            if (cmd.hasOption("L")) {
                RedirectHandler.handleRedirect(cmd, httpRequest);
            }
        } catch (ParseException ignore) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(Scurl.class.getSimpleName(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
