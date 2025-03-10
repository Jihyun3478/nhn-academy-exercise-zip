package com.example.thread.quiz01;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter("counter", 10);
        counter.run();
    }
}
