class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
    }
}

public class LinkedList implements List {
    Node head;
    int size;

    public LinkedList() {}

    public void add(Object item) {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = node;
        }
        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }

    public Object get(int index) {
        validateRange(index);

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    public void remove(int index) {
        validateRange(index);

        if (head == null || index < 0) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            return;
        }

        current.next = current.next.next;
    }

    @Override
    public void iterator() {
        Node current = head;

        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private void validateRange(int index) {
        if(index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index Ouf Of Range!");
        }
    }

    @Override
    public Enumerator getEnumerator() {
        return new LinkedListEnumerator(this);
    }
}