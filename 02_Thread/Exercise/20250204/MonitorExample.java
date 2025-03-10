class SharedResource {
    public synchronized void method() { // 모니터 획득
        System.out.println(Thread.currentThread().getName() + "실행 중");
        try {
            Thread.sleep(1000); // 임계영역
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } // 모니터 해제
}

public class MonitorExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.method(), "Thread-1");
        Thread t2 = new Thread(() -> resource.method(), "Thread-2");

        t1.start();
        t2.start();
    }
}