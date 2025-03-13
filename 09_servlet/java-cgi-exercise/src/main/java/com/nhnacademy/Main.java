package com.nhnacademy;

import com.beust.jcommander.JCommander;

public class Main {
    public static void main(String[] args) {
        args[0] = "java -jar ../../target/cgi-shade.jar  \\\n-content-type text/html \\\n-method get \\\n-query-string '?page=2&id=marco' \\\n-server-name my-server \\\n-server-port 8080 \\\n-path /index.html \\\n-body hello";
        CgiArgs cgiArgs = new CgiArgs();

        JCommander.newBuilder()
            .addObject(cgiArgs)
            .build()
            .parse(args);

        System.out.println("content-type:" + cgiArgs.getContentType());
        System.out.println("method:" + cgiArgs.getMethod());
        System.out.println("query-string:" + cgiArgs.getQueryString());
        System.out.println("server-name:" + cgiArgs.getServerName());
        System.out.println("server-port:" + cgiArgs.getPort());
        System.out.println("path:" + cgiArgs.getPath());
        System.out.println("body:" + cgiArgs.getBody());
    }
}
