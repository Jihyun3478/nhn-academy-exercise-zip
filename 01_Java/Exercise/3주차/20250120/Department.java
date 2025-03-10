import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Department {
    ArrayList<Student> list = new ArrayList<>();

    // public List<Integer> filter(Predicate<Integer> predicate) {
    //     List<Integer> list = new ArrayList<>();
    //     for (Integer n : this.list) {
    //         if (predicate.test(n)) {
    //             list.add(n);
    //         }
    //     }
    //     return list;
    // }

    public List<Student> studentFilter(Predicate<Student> predicate) {
        List<Student> list = new ArrayList<>();
        for (Student s : this.list) {
            if (predicate.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public void accept(Consumer<Student> consumer) {
        for(Student s : this.list) {
            consumer.accept(s);
        }
    }
}
