import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<String> coll = new HashSet<>();

        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("d");
        coll.add("e");

        // Iterator<String> iterator = coll.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }

        coll.forEach(System.out::println);
    }
}