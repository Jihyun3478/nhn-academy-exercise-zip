package com.example.thread.quiz02;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter("threadCounter", 10);
        Thread thread = new Thread(counter);
        thread.start();
    }
}
