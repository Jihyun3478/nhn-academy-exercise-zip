public class Stack<T> {
    private T[] elements;
    private int index;

    public Stack(int size) {
        this.elements = (T[]) new Object[size];
        this.index = 0;
    }

    public void push(T element) {
        this.elements[this.index++] = element;
    }

    public T pop() {
        T result = this.elements[--index];
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>("5")
    }
}