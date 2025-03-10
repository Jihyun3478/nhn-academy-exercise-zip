public class App {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("locked resource 1: " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        thread1.setName("Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("locked resource 1: " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

                synchronized (resource2) {
                    System.out.println("locked resource 2: " + Thread.currentThread().getName());
                }
            }
        });
        thread2.setName("Thread-2");

        Thread thread3 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("locked resource 2: " + Thread.currentThread().getName());

                try {
                    while (true) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        thread3.setName("Thread-3");

        try {
            thread3.start();
            Thread.sleep(1000);
            thread2.start();
            Thread.sleep(1000);
            thread1.start();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
