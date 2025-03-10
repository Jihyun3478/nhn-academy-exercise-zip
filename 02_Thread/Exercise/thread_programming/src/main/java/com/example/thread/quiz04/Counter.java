package com.example.thread.quiz04;

public class Counter extends Thread {
    private String name;
    private long count;
    private long maxCount;

    public Counter(String name, long maxCount) {
        this.name = name;
        this.count = 0L;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        do {
            count++;
            System.out.println(name + " : " + count);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while(count != maxCount);
    }
}
