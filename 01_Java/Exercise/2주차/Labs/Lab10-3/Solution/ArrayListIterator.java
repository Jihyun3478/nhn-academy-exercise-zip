public class ArrayListIterator implements Iterator {
    private ArrayList list;
    private int index = 0;

    public ArrayListIterator(ArrayList list) {
        this.list = list;
    }

    public boolean hasNext() {
        return (this.index < this.list.size()) ? true : false;
    }

    public int next() {
        return list.get(this.index++);
    }
}
