package com.example.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.example.http.channel.HttpJob;

public class HttpServer {
    private static final int DEFAULT_PORT = 80;

    private final int port;

    public HttpServer() {
        this(DEFAULT_PORT);
    }

    public HttpServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Server start..");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket client = serverSocket.accept();
                HttpJob httpJob = new HttpJob(client);
                httpJob.execute();
            }
        } catch (IOException e) {
            System.err.println("server error: " + e);
        }
    }
}
