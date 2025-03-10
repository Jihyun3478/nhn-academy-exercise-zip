public class ArrayList<extends Comparable<E>> List<E> {
    private E[] elements;
    private int index = 0;

    public ArrayList() {
        this.elements = (E[]) new Object[5];
    }

    public ArrayList(int size) {
        this.elements = (E[]) new Object[size];
    }

    public void add(E item) {
        validateRange(index);
        elements[index++] = item;
    }

    public E get(int index) {
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
        return this.index;
    }

    @Override
    public boolean isEmpty() {
        if(this.index == 0) {
            return true;
        }
        return false;
    }

    public <E extends Comparable<E>> void sort() {
        int n = elements.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (elements[j].compareTo(elements[j+1]) > 0) {
                    E temp = (E) elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
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
}