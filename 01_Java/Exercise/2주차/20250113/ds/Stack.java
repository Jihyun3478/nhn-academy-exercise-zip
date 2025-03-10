package ds;
interface DataStructure {
    void add(Object o);
    void remove(int index);
    
}

abstract class ObjectStructure {
    Object[] object = new Object[10];

    public void init() {
        java.util.Arrays.fill(null, this.object);
    }
}

public class Stack extends ObjectStructure implements DataStructure {
    public void add(Object o) {

    }

    public void remove(int index) {

    }
}
