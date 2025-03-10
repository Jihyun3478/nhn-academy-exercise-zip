package com.example.runnable.quiz01;

public class RunnableCounter implements Runnable {
    private String name;
    private long count;
    private long maxCount;

    public RunnableCounter(String name, long maxCount) {
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
