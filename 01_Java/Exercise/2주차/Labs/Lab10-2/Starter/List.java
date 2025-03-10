public interface List extends Enumerable {
    void add(Object item);
    Object get(int index);
    void remove(int index);
    boolean isEmpty();
    int size();
    void iterator();
}
