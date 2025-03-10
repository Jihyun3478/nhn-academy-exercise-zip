public class NonSingleton {
    private int i;

    public NonSingleton() {}

    public int getNextValue() {
        return i++;
    }

    public int getValue() {
        return i;
    }
}

class Test3 {
    public static void main(String[] args) {
        NonSingleton nonSingleton = new NonSingleton();
        int n1 = nonSingleton.getNextValue();
        System.out.println(n1);
        int n2 = nonSingleton.getNextValue();
        System.out.println(n2);

        NonSingleton nonSingleton2 = new NonSingleton();
        int n3 = nonSingleton2.getNextValue();
        System.out.println(n3);
        int n4 = nonSingleton2.getNextValue();
        System.out.println(n4);
    }
}