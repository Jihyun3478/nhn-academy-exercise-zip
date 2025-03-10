import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Generator implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();

        /* 이렇게도 쓸 수 있음 */
        // Iterator<Integer> iter = new Iterator<Integer>() {
        //     @Override
        //     public boolean hasNext() {
        //         return false;
        //     }

        //     @Override
        //     public Integer next() {
        //         return null;
        //     }
        // };
    }

    public static class IntIterator implements Iterator<Integer> {
        static int result = 0;

        public boolean hasNext() {
            return true;
        }

        public Integer next() {
            try {
                result += 1;
                Thread.sleep(500);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            return result;
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        
        // numbers.stream()
        //     .map(number -> number * 2)
        //     .forEach(System.out::println);

        numbers.parallelStream()
            .map(number -> number * 2)
            .forEach(System.out::println);

        // Generator generator = new Generator();

        // Iterator<Integer> iter = generator.iterator();
        // while (iter.hasNext()) {
        //     System.out.println(iter.next());
        // }

        // for (int i : generator) {
        //     System.out.println(i);
        // }
    }
}