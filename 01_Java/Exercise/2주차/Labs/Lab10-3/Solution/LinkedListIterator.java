public class LinkedListIterator implements Iterator {
    private LinkedList list;
    private int index = 0;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
    }

    public boolean hasNext() {
        return (this.index < this.list.size()) ? true : false;
    }

    public int next() {
        return list.get(this.index++);
    }
}
