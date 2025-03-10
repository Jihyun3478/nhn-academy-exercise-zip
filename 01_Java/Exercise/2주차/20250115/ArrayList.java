import java.util.Arrays;

public class ArrayList implements List {
    private Object[] elements;
    private int index = 0;

    public ArrayList() {
        elements = new Object[10];
    }

    public void add(Object o) {
        if(index >= elements.length) {
            throw new IllegalArgumentException("Index is more than array length.");
        }
        elements[index++] = o;
    }

    public Object get(int index) {
        return elements[index];
    }

    public void remove(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Index is less than zero.");
        }
        // elements[index--] = null;
        for(int i = index; i < this.index; i++) {
            this.elements[i] = this.elements[i+1];
            index--;
        }
    }

    public Object size() {
        int size = 0;
        for(int i = 0; i < elements.length; i++) {
            if(elements[i] != null) {
                size++;
            }
        }
        return size;
    }

    public void newElements() {
        elements = Arrays.copyOf(elements, index * 2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        for (Object element : elements) {
            sb.append(element + " ");
        }
        sb.append("}");

        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        try {
            List arrayList = new ArrayList();

            System.out.println("======== add ========");
            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(2);
            System.out.println(arrayList.toString() + "\n");
            
            System.out.println("======== get ========");
            System.out.println(arrayList.get(0));
            System.out.println(arrayList.get(1));
            System.out.println(arrayList.get(2) + "\n");
            
            System.out.println("======== size ========");
            System.out.println(arrayList.size() + "\n");

            System.out.println("======== remove ========");
            arrayList.remove(1);
            System.out.println(arrayList.toString() + "\n");

            System.out.println("======== Out Of Range Test ========");
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(5);

            // System.out.println("======== more add ========");
            // arrayList.add(4);
            // arrayList.add(5);
            // arrayList.add(6);
            // System.out.println(arrayList.toString() + "\n");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}