class A {
    public static void a() {
        System.out.println("A");
    }
}

class B extends A {
    public static void a() {
        System.out.println("B");
    }
}

class C extends B {
    public static void a() {
        System.out.println("C");
    }
}

class D extends C {
    public static void a() {
        System.out.println("D");
    }
}

class Test {
    public static void main(String[] args) {
        D d = new D();
        C c  = d;
        B b  = c;
        A a = b;
    }
}