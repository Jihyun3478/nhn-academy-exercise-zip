class A {
    public void a() {
        System.out.println("A");
    }
}

class B extends A {
    public void a() {
        System.out.println("B");
    }
}
 
class C extends B {
    public void a() {
        System.out.println("C");
    }
}
 
class D extends C {
    public void a() {
        System.out.println("D");
    }
}

public class Task {
    public static void main(String[] args) {
        // D d = new D();
        // A a = (a) d;
        // B b = a;
        // C c = a;

        D d = new D();
        A a = (A) d;
        B b = a;
        C c = a;
    }
}
