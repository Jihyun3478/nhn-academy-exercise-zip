public class Stack<E> {
    private E[] elements;
    private int index = 0;

    public Stack(int size) {
        this.elements = (E[])new Object[size];       
    }

    public void push(E element) {
        this.elements[this.index] = element;
        this.index++;
    }

    public E pop() {
        return this.elements[--this.index];
    }
}
