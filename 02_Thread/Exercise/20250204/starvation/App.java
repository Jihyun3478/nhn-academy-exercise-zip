import java.util.Map;

import count.SharedCounter;
import thread.CounterIncreaseHandler;

public class App {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter(0L);

        CounterIncreaseHandler counterIncreaseHandler = new CounterIncreaseHandler(sharedCounter);

        Thread threadA = new Thread(counterIncreaseHandler, "thread-A");
        Thread threadB = new Thread(counterIncreaseHandler, "thread-B");
        Thread threadC = new Thread(counterIncreaseHandler, "thread-C");
        Thread threadD = new Thread(counterIncreaseHandler, "thread-D");
        Thread threadE = new Thread(counterIncreaseHandler, "thread-E");

        threadA.setPriority(10);
        threadB.setPriority(1);
        threadC.setPriority(1);
        threadD.setPriority(1);
        threadE.setPriority(1);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();

        try {
            Thread.sleep(1000);
            threadA.interrupt();
            threadB.interrupt();
            threadC.interrupt();
            threadD.interrupt();
            threadE.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (threadA.isAlive() && threadB.isAlive() && threadC.isAlive() && threadD.isAlive() && threadE.isAlive()) {
            Thread.yield();
        }

        Map<String, Long> result = counterIncreaseHandler.getThreadHistory();
        result.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        System.out.println("System exit!");
    }
}
