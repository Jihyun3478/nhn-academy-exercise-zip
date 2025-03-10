public class DaemonThreadCheck {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("스레드 실행"));

        System.out.println("데몬 스레드 여부 (기본값) : " + thread.isDaemon());

        thread.setDaemon(true);
        System.out.println("데몬 스레드 여부 (설정 후) : " + thread.isDaemon());

        thread.start();
    }
}
