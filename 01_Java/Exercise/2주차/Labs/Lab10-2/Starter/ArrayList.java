public class ArrayList implements List {
    private Object[] elements;
    private int index = 0;

    public ArrayList() {
        this.elements = new Object[5];
    }

    public ArrayList(int size) {
        this.elements = new Object[size];
    }

    public void add(Object item) {
        validateRange(index);
        elements[index++] = item;
    }

    public Object get(int index) {
        validateRange(index);
        return elements[index];
    }

    public void remove(int index) {
        validateRange(index);
        for(int i = index; i < this.index; i++) {
            elements[i] = elements[i+1];
        }
        this.index--;
    }

    public int size() {
        // int size = 0;
        // for(Object element : elements) {
        //     if(element == null) {
        //         size++;
        //     }
        // }
        // return size;
        return this.index;
    }

    @Override
    public boolean isEmpty() {
        if(this.index == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void iterator() {
        for (int i = 0; i < index; i++) {
            System.out.println(elements[i]);
        }
    }

    public Object[] getElements() {
        return elements;
    }

    private void validateRange(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Index Ouf Of Range!");
        }
    }

    @Override
    public Enumerator getEnumerator() {
        return new ArrayListEnumerator(this);
    }
}