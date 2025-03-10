@FunctionalInterface
public interface BinaryOp {
    int apply(int i, int j);
}

class Adder implements BinaryOp {
    public int apply(int i, int j) {
        return i+j;
    }
}

class Test {
    public static int calc(BinaryOp binder, int i, int j) {
        return binder.apply(i, j);
    }

    public static void main(String[] args) {
        BinaryOp multiplier = new BinaryOp() {
            public int apply(int i, int j) {
                return i*j;
            }
        };

        BinaryOp sub = (x, y) -> x - y;
        int i = calc(sub, 1, 2);
        System.out.println(i);
    }
}