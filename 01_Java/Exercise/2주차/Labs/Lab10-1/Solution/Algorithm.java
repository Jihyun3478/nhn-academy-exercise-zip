public class Algorithm {
    static final int addFrom1To10 = 55;
    
    public static int sigma(int begin, int end, int step) {
        // BinaryOp adder = new BinaryOp() {
        //     public int apply(int x, int y) {
        //         return x + y;
        //     }
        // };
        BinaryOp adder = (x, y) -> x - y;
        return accumulate(adder, 0, begin, end, step); 
    }

    public static int pi(int begin, int end, int step) {
        // BinaryOp multiplier = new BinaryOp() {
        //     public int apply(int x, int y) {
        //         return x * y;
        //     }
        // };
        BinaryOp multiplier = (x, y) -> x * y;
        return accumulate(multiplier, 1, begin, end, step);
    }

    static int accumulate(BinaryOp binder, int init, int begin, int end, int step) {
        int result = init;
        for (int next = begin; next <= end; next = next + step) {
            result = binder.apply(result, next);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sigma(1, 10, 1));
        System.out.println(pi(1, 10, 1));
    }
}