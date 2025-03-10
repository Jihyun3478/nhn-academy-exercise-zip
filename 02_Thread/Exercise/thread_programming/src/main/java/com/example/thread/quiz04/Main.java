package com.example.thread.quiz04;

public class Main {
    public static void main(String[] args) {
        // Counter counter1 = new Counter("threadCounter1", 10);
        // Counter counter2 = new Counter("threadCounter2", 10);
        // Thread thread1 = new Thread(counter1);
        // Thread thread2 = new Thread(counter2);
        // thread1.start();
        // thread2.start();
        // System.out.println(Thread.currentThread().getName());

        for (Thread t : Thread.getAllStackTraces().keySet()) {
            System.out.println("스레드 이름: " + t.getName() + ", ID: " + t.getId() + ", 상태: " + t.getState());
        }
    }
}
