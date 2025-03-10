import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Integer> list;

    public Data() {
        this.list = new ArrayList<>();
    }

    public void add(Integer value) {
        this.list.add(value);
    }

    public void map(UnaryOp op) {
        for(int i = 0; i < this.list.size(); i++) {
            list.set(i, op.apply(list.get(i)));
        }
    }
}


class Test {
    public static void main(String[] args) {
        Data data = new Data();
        data.add(1);
        data.add(2);
        data.add(3);
        
        data.map(i -> i+1);

        for(int i : data.list) {
            System.out.println(i);
        }
    }
}