package com.example.thread.quiz01;

public class Counter {
    private String name;
    private long count;

    public Counter(String name, long maxCount) {
        this.name = name;
        this.count = maxCount;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
