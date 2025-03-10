class Node {
    Object data;
    Node nextNode;

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
            while (head.nextNode != null) {
                head = head.nextNode;
            }
            head.nextNode = node;
        }
        this.size++;
    }

    public Object get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = head.nextNode;
        }
        return current.data;
    }

    public int size() {
        return this.size;
    }

    public Enumerator getEnumerator() {
        return new LinkedListEnumerator(this);
    }

    public boolean isEmpty() {
        return this.head == null ? true : false;
    }
}
