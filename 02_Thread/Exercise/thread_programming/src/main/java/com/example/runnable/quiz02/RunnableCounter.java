package com.example.runnable.quiz02;

public class RunnableCounter implements Runnable {
    private boolean stopped = false;
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
        while (!stopped) {
            count++;
            System.out.println(name + " : " + count);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}
