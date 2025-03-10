import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.List;

public class Test {
    public static int add(int i, int j) {
        return i + j;
    }

    public static int calc(BinaryOp binder, int i, int j) {
        return binder.apply(i, j);
    }

    public static void main(String[] args) {
        Department dep = new Department();

        dep.list.add(new Student(0, "jihyun", "a"));
        dep.list.add(new Student(1, "jay", "b"));
        dep.list.add(new Student(2, "sam", "c"));

        Predicate<Student> isEven = s -> s.name.contains("j");
        List<Student> students1 = dep.studentFilter(isEven);

        for(Student s : students1) {
            System.out.println(s.toString());
        }
        System.out.println();

        Consumer<Student> students2 = s -> System.out.println(s);
        dep.accept(students2);
    }
}
