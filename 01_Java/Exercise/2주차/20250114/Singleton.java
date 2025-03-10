public class Singleton {
    private int accountNo = 0;
    static Singleton singleton;

    private Singleton() {}

    public int getNextNumber() {
        return accountNo++;
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
    }
}