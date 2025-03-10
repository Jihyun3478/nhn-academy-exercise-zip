import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

// 슈퍼 타입 제한 와일드 카드 : E extends Person
// 와일드 카드에 들어갈 수 있는 타입 인수를 주어진 타입이거나 상속된 타입으로만 제한
public class Department<E extends Person> implements Iterable<E> { // Comparable<E>
    private ArrayList<E> list;
    private ArrayList<Integer> integerList;
    private int no;
    private String name;

    public Department(int no, String name) {
        this.no = no;
        this.name = name;
        this.list = new ArrayList<>();
        this.integerList = new ArrayList<>();
    }

    public void add(E e) {
        this.list.add(e);
    }

    public E getStudent(int index) {
        return this.list.get(index);
    }

    public Iterator<E> iterator() {
        return list.iterator();
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    // 어떤걸 기준으로 정렬할지 정해주지 않았기 때문에 에러 발생.
    // 'ArrayList<E> list' -> 'ArrayList<Integer> integerList' 로 명시해줌으로써 해결.
    public void sort() {
        Collections.sort(integerList);
    }

    /* 
    직접 만든 ArrayList가 아닌 java.util.ArrayList를 사용함으로써 에러 해결. 
    그 이유는 sort는 내부적으로 List<T>를 이용해 돌아가기 때문임.

    ======== Collections.sort() 문서 ========
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
    */
    public void sort(Comparator<E> comparator) {
        Collections.sort(this.list, comparator);
    }

    /* 
    직접 만든 ArrayList가 아닌 java.util.ArrayList를 사용함으로써 에러 해결. 
    그 이유는 sort는 내부적으로 List<T>를 이용해 돌아가기 때문임.
    
    ======== Collections.sort() 문서 ========
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
    */
    public void sortByName() {
        Collections.sort(this.list, (pe1, pe2) -> pe1.getName().compareTo(pe2.getName()));
    }

    @Override
    public String toString() {
        return this.no + ", " + this.name;
    }
}