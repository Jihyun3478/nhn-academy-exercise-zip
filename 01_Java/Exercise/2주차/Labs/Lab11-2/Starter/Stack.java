public class Stack {
    private int[] elements;
    private int index = 0;

    public Stack(int size) {
        this.elements = new int[size];
    }

    public void push(int element) {
        this.elements[index] = element;
        this.index++;
    }

    public int pop() {
        return this.elements[--this.index];
    }
}