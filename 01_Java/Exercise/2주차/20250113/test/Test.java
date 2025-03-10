package test;
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.socno = "111111-111111";
        p1.name = "Jihyun";

        Person p2 = new Person();
        p2.socno = "111111-111111";
        p2.name = "Jihyun";

        Test t = new Test();
        t.main(new String[] {"aaa", "bbb"});
    }
}

class Person {
    String socno;
    String name;

    public String getName() {
        return this.name;
    }
}