package com.example.runnable.quiz01;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableCounter("runnableCounter", 10));
        thread1.start();
    }
}
