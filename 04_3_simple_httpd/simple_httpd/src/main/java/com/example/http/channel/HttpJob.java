package com.example.http.channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class HttpJob implements Executable {
    private static final String CRLF = "\r\n";

    private final Socket client;

    public HttpJob(Socket client) {
        if (Objects.isNull(client)) {
            throw new IllegalArgumentException("Client Socket is null!");
        }
        this.client = client;
    }

    @Override
    public void execute() throws IOException {
        StringBuilder requestBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()))
        ) {
            while (true) {
                String line = bufferedReader.readLine();
                System.out.println(line);
                requestBuilder.append(line);
                if (Objects.isNull(line) || line.length() == 0) {
                    break;
                }
            }

            // System.out.println(requestBuilder.toString());

            StringBuilder responseBody = new StringBuilder();
            responseBody.append("<html>");
            responseBody.append("<body>");
            responseBody.append(String.format("<h1>{%s}hello java</h1>", Thread.currentThread().getName()));
            responseBody.append("</body>");
            responseBody.append("</html>");

            StringBuilder responseHeader = new StringBuilder();
            responseHeader.append(String.format("HTTP/1.0 200 OK%s", CRLF));
            responseHeader.append(String.format("Server: HTTP server/0.1%s", CRLF));
            responseHeader.append(String.format("Content-type: text/html; charset=%s%s", "UTF-8", CRLF));
            responseHeader.append(String.format("Connection: Closed%s", CRLF));
            responseHeader.append(
                String.format("Content-Length:%d %s%s", responseBody.toString().getBytes().length, CRLF, CRLF));

            printWriter.write(responseHeader.toString());
            printWriter.write(responseBody.toString());
            printWriter.flush();
            printWriter.close();
            client.close();

        } catch (IOException e) {
            System.err.println("server error: " + e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
