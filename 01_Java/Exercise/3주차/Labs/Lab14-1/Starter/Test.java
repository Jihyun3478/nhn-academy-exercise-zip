import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Test {
    private static final int SIZE = 100;

    public static int hashFunction(Object o) {
        return Math.abs(o.hashCode()) % SIZE;
    }

    public static void main(String[] args) {
        String s = "Jihyun";

        System.out.println(s.hashCode());
        int i = hashFunction(s);
        System.out.println(i);

        User user = new User(1, "Jihyun", 25);

        System.out.println(user.hashCode());
        int j = hashFunction(user);
        System.out.println(j);
    }
}
