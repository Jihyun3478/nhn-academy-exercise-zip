public class SuperClass {
    public void add() {
        System.out.println("Called at Super class.");
    }
}

class SubClass extends SuperClass {
    public void add() {
        System.out.println("Called at Sub class.");
    }
}

class Test {
    public static void main(String[] args) {
        SuperClass s1 = new SubClass();
        SubClass s2 = new SubClass();

        s1.add();
        s2.add();
    }
}