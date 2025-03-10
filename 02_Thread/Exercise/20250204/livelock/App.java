public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            while (counter.getCount() < 10) {
                counter.increment();
            }
        };

        Thread threadA = new Thread(task, "counter-A");
        Thread threadB = new Thread(task, "counter-B");

        threadA.start();
        threadB.start();
    }
}
