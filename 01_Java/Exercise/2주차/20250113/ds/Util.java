package ds;
public class Util {
    public static void addToDS(DataStructure ds, Object item) {
        ds.add(item);
    }
}

class Test {
    public static void main(String[] args) {
        Stack s = new Stack();
        Queue q = new Queue();
        Util.addToDS(q, "abc");
    }
}