public class LinkedListEnumerator implements Enumerator {
    LinkedList list;
    int index = 0;
    
    public LinkedListEnumerator(LinkedList list) {
        this.list = list;
    }

    public boolean hasNext() {
        return list.head != null;
    }

    public Object next() {
        Object data = list.head.data;
        list.head = list.head.nextNode;
        return data;
    }
}
