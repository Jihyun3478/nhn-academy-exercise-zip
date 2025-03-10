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
            Node current = this.head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = node;
        }
        this.size++;
    }

    public Object get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
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
        if (head == null || index < 0) {
            return;
        }

        if (index == 0) {
            head = head.nextNode;
            return;
        }

        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.nextNode;
        }

        if (current == null || current.nextNode == null) {
            return;
        }

        current.nextNode = current.nextNode.nextNode;
    }
}
