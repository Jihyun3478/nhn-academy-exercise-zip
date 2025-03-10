using System;

class A {
    public virtual a() {
        Console.WriteLine("A");
    }
}

class B : A {
    public override a() {
        Console.WriteLine("B");
    }
}

class C : B {
    public new virtual a() {
        Console.WriteLine("C");
    }
}

class D : C {
    public override a() {
        Console.WriteLine("D");
    }
}

class Test {
    public static void main(string[] args) {
        D d = new D();
        C c  = d;
        B b  = c;
        A a = b;
    }
}