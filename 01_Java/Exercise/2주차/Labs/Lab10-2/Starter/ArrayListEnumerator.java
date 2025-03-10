public class ArrayListEnumerator implements Enumerator {
    private ArrayList list;
    private int index = 0;

    public ArrayListEnumerator(ArrayList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (this.index >= this.list.size()) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return this.list.get(this.index++);
    }
}
