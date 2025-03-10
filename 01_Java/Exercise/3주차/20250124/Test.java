import java.util.*;

class Sample {
    public static List<Integer> getIntegers() {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < 100000000; i++) {
            result.add(i);
        }
        return result;
    }
}

class Iterator {
    List<Integer> list = new ArrayList<>();
    int index;

    public Iterator(List<Integer> list) {
        this.list = list;
        this.index = 0;
    }

    public boolean hasNext() {
		if (this.list.isEmpty()) {
			return false;
		}
		return true;
	}

	public int next() {
        int nextValue = this.list.get(index);
        index++;
		return nextValue;
	}
}

public class Test {
    public static void main(String[] args) {
        try {
            List<Integer> list = Sample.getIntegers();
            Iterator iterator = new Iterator(list);
    
            long beforeTime = System.currentTimeMillis();
            for (int i : list) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            long afterTime = System.currentTimeMillis();
            System.out.println("for문 실행시간 : " + (afterTime - beforeTime)/1000 + "s");
    
            long beforeTime2 = System.currentTimeMillis();
            while (iterator.hasNext()) {
                if (iterator.next() % 2 == 0) {
                    System.out.println(iterator.next());
                }
            }
            long afterTime2 = System.currentTimeMillis();
            System.out.println("iterator 실행시간 : " + (afterTime2 - beforeTime2)/1000 + "s");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    } 
}