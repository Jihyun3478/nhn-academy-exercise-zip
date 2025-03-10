public class Sample {
    static int max(int i, int j) {
        return (i > j) ? i : j;
    }

    static int max(int i, int j, int k) {
        return max(max(i, j), k);
    }

    public static void main(String[] args) {
        max(1, 2, 3);
    }
}