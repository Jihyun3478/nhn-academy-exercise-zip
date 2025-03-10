package com.example.runnable.quiz02;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.process();
    }

    public void process() {
        RunnableCounter rc = new RunnableCounter("runnableCounter", 10);
        Thread thread = new Thread(rc);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rc.stop();
    }
}
