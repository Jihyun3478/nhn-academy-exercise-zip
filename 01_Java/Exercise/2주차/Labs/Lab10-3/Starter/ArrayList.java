public class ArrayList implements List {
    private int[] elements;
    private int index = 0;

    public ArrayList() {
        this.elements = new int[50];
    }

    public void add(int data) {
        try {
            this.elements[index++] = data;
        }
        catch (Exception e) {
            throw new ArrayListInvalidOperationException("Cannot add new data to ArrayList");
        }
    }

    public int remove(int index) {
        int returnValue = this.elements[index];

        for (int i = index; i < this.index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.index--;

        return returnValue;
    }

    public int get(int index) {
        if (this.index <= index) {
            throw new ArrayListInvalidOperationException("Can remove data");
        }
        return this.elements[index];
    }

    public int size() {
        return this.index;
    }
}
