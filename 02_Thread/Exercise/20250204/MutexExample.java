import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void method() {
        lock.lock(); // 락 획득
        try {
            System.out.println(Thread.currentThread().getName() + "실행 중");

            Thread.sleep(1000); // 임계영역
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 락 해제
        }
    }
}

public class MutexExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.method(), "Thread-1");
        Thread t2 = new Thread(() -> resource.method(), "Thread-2");

        t1.start();
        t2.start();
    }
}
