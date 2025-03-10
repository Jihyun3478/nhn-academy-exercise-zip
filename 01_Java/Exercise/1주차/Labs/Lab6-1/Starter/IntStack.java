import java.util.Arrays;

public class IntStack {
    int[] array = new int[5];
    int index = 0;

    public void push(int element) {
        if(index >= array.length) {
            throw new IllegalArgumentException("Stack is full!");
        }
        array[index] = element;
        index++; 
    }

    public int pop() {
        if(index <= 0) {
            throw new IllegalArgumentException("Stack is empty!");     
        }
        int temp = array[--index];
        return temp;
    }
}

class Test {
    public static void main(String[] args) {
        try {
            IntStack stack = new IntStack();
            // stack.push(1);
            // stack.push(2);
            // stack.push(3);
            // stack.push(4);
            // stack.push(5);
            // stack.push(6);

            stack.pop();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}