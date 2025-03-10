public class ArrayListEnumerator implements Enumerator {
    ArrayList list;
    int index = 0;

    public ArrayListEnumerator(ArrayList list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (this.index >= this.list.size()) {
            return false;
        }
        else {
            return true;
        }
    }

    public Object next() {
        return this.list.get(this.index++);
    }
}
