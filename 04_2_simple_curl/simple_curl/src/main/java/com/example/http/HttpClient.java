package com.example.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;

import org.apache.commons.cli.CommandLine;

import com.example.http.request.HttpRequest;
import com.example.http.response.HttpResponse;
import com.example.http.response.HttpResponseImpl;

/**
 * 서버와 통신하는 클래스
 */
public class HttpClient {
    private static final String CRLF = "\r\n";
    private static final String BOUNDARY = "----WebKitFormBoundaryXxXxXxXx";
    private static int status;

    /**
     * 서버와 통신하여 HTTP 요청을 전송하고 응답을 반환하는 메서드
     */
    public static HttpResponse sendRequest(CommandLine cmd, HttpRequest httpRequest) {
        try (Socket client = new Socket(httpRequest.getHost(), 80);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true)
        ) {
            printConnectionInfo(cmd, client, httpRequest);

            StringBuilder requestBuilder = buildRequest(cmd, httpRequest);

            if (cmd.hasOption("F")) {
                handleFileUpload(cmd, client, printWriter, requestBuilder);
            } else {
                printWriter.write(requestBuilder.append(CRLF).toString());
                printWriter.flush();
            }

            readResponse(cmd, bufferedReader, httpRequest);

        } catch (IOException e) {
            throw new RuntimeException("서버와의 통신 중 오류 발생: " + e.getMessage(), e);
        }
        return new HttpResponseImpl(status, httpRequest.getHeaders(), httpRequest.getBody());
    }

    private static void printConnectionInfo(CommandLine cmd, Socket client, HttpRequest httpRequest) {
        if (cmd.hasOption("v")) {
            System.out.println("* Trying " + client.getInetAddress().getHostAddress() + ":80...");
            System.out.println("* Connected to " + httpRequest.getHost() + " (" + client.getInetAddress().getHostAddress() + ") port 80");
        }
    }

    private static StringBuilder buildRequest(CommandLine cmd, HttpRequest httpRequest) {
        if (cmd.hasOption("X")) {
            String optionValue = cmd.getOptionValue("X");
            if (optionValue == null || optionValue.isEmpty()) {
                throw new IllegalArgumentException("-X 옵션의 값을 지정해야 합니다.");
            }
            httpRequest.setMethod(optionValue);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(httpRequest.getMethod()).append(" ").append(httpRequest.getPath()).append(" HTTP/1.1").append(CRLF);
        builder.append("Host: ").append(httpRequest.getHost()).append(CRLF);
        builder.append("User-Agent: curl/7.79.1").append(CRLF);
        builder.append("Accept: */*").append(CRLF);

        if (cmd.hasOption("H")) {
            builder.append(cmd.getOptionValue("H")).append(CRLF);
        }

        if (cmd.hasOption("d")) {
            String data = cmd.getOptionValue("d");
            builder.append("Content-Length: ").append(data.length()).append(CRLF).append(CRLF);
            builder.append(data).append(CRLF);
        }

        return builder;
    }

    private static void handleFileUpload(CommandLine cmd, Socket client, PrintWriter printWriter, StringBuilder builder) throws IOException {
        String filePath = cmd.getOptionValue("F").split("=@")[1];
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + filePath);
        }

        String fileName = file.getName();
        String contentType = Files.probeContentType(file.toPath());
        byte[] fileBytes = Files.readAllBytes(file.toPath());

        builder.append("Content-Type: multipart/form-data; boundary=").append(BOUNDARY).append(CRLF);

        StringBuilder fileHeader = new StringBuilder();
        fileHeader.append("--").append(BOUNDARY).append(CRLF);
        fileHeader.append("Content-Disposition: form-data; name=\"upload\"; filename=\"")
            .append(fileName).append("\"").append(CRLF);
        fileHeader.append("Content-Type: ").append(contentType).append(CRLF);
        fileHeader.append(CRLF);

        int contentLength = fileHeader.length() + fileBytes.length + (CRLF + "--" + BOUNDARY + "--" + CRLF).length();
        builder.append("Content-Length: ").append(contentLength).append(CRLF).append(CRLF);

        printWriter.write(builder.toString());
        printWriter.flush();

        printWriter.write(fileHeader.toString());
        printWriter.flush();

        client.getOutputStream().write(fileBytes);
        client.getOutputStream().flush();

        String endBoundary = CRLF + "--" + BOUNDARY + "--" + CRLF;
        printWriter.write(endBoundary);
        printWriter.flush();
    }

    private static void readResponse(CommandLine cmd, BufferedReader reader, HttpRequest httpRequest) throws IOException {
        String line;
        boolean isHeader = true;

        while ((line = reader.readLine()) != null) {
            if (line.contains(":")) {
                int index = line.indexOf(":");
                String key = line.substring(0, index).trim();
                String value = line.substring(index + 1).trim();
                httpRequest.addHeader(key, value);
            } else if (!line.isEmpty() && (line.startsWith("{") || line.startsWith("\""))) {
                httpRequest.addBody(line);
            }

            if (cmd.hasOption("v")) {
                if (isHeader) {
                    System.out.println("< " + line);
                    if (line.isEmpty()) isHeader = false;
                } else {
                    System.out.println(line);
                }
            } else {
                System.out.println(line);
            }

            if (httpRequest.getPath().contains("status")) {
                status = Integer.parseInt(httpRequest.getPath().replaceAll("/status/", ""));
            }
        }
    }
}
