import java.util.*;

class CustomList<E> {
    E[] elements;

    public CustomList() {
        this.elements = (E) new Object[10];
    }

    public List<E> map(BinaryOp binder, List<E> e1, List<E> e2) {
        List<E> list = new ArrayList<>();
        for(int i = 0; i < elements.length; i++) {
            elements[i] = binder.apply(e1.get(i), e2.get(i));
            list.add(elements[i]);
        }
        return list;
    }

    public List<E> zip(List<E> list1, List<E> list2) {
        List<E> newList = new ArrayList<>();
        for(int i = 0; i < list1.length; i++) {
            newList.add(list1.get(i) + " " + list2.get(i));
        }
        return newList;
    }

    public List<Integer> filter() {
        List<Integer> integerList = new ArrayList<>;
        for (E e : elements) {
            if(e instanceof Integer) {
                integerList.add(e);
            }
        }
        return integerList;
    }
}

public class Test {
    public static void main(String[] args) {
        CustomList<Integer> customList = new CustomList<>();

        for(int i = 0; i < 1000; i++) {
            list.add(i);
        }

        customList.map(i -> i + 1)
            .filter(i -> i < 10)
            .forEach(System.out::println);
    }
}