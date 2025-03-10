public class LinkedList implements List {
    private Node headNode;
    private int count = 0;

    public LinkedList() {
        this.headNode = null;
    }

    private class Node {
        private int data;
        private Node nextNode;

        Node(int data) {
            this.data = data;
            this.nextNode = null;
        }

        public int getData() {
            return this.data;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }

        public Node getNextNode() {
            return this.nextNode;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (headNode == null) {
            this.headNode = newNode;
            return;
        }

        Node lastNode = this.headNode;
        while(lastNode.getNextNode() != null) {
            lastNode = lastNode.getNextNode();
        }

        lastNode.setNextNode(newNode);
        this.count++;
    }

    public int remove(int index) {
        // if (this.headNode == null) {
        //     throw new LinkedListInvalidOperationException("List is empty");
        // }

        int returnValue = 0;

        if (index == 0) {
            returnValue = this.get(0);
            this.headNode = this.headNode.getNextNode();
            return returnValue;
        }

        Node tempNode = this.getNode(index - 1);
        returnValue = tempNode.getNextNode().getData();
        tempNode.setNextNode(tempNode.getNextNode().getNextNode());

        this.count--;
        return returnValue;
    }

    private Node getNode(int index) {
        Node currentNode = this.headNode;
        int count = 0;

        while(currentNode != null) {
            if (count == index) {
                return currentNode;
            }
            count++;
            currentNode = currentNode.getNextNode();
        }
        throw new LinkedListInvalidOperationException("Cannot remove data");
    }

    public int get(int index) {
        Node currentNode = this.headNode;
        int count = 0;

        while(currentNode != null) {
            if (count == index) {
                return currentNode.getData();
            }
            count++;
            currentNode = currentNode.getNextNode();
        }
        throw new LinkedListInvalidOperationException("Cannot remove data");
    }


    public int size() {
        return this.count;
    }
}
