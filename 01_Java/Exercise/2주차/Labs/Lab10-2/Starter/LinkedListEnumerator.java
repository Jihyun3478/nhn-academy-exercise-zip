public class LinkedListEnumerator implements Enumerator {
    private LinkedList list;
    private int index = 0;

    public LinkedListEnumerator(LinkedList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.head != null;
    }

    @Override
    public Object next() {
        Object data = list.head.data;
        list.head = list.head.next;
        
        return data;
    }
}
