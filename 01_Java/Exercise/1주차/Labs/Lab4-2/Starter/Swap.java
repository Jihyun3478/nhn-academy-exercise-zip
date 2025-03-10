public class Swap {
    public static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;

        System.out.printf("in swap function: %d, %d\n", i, j);
    }

    public static void main(String[] args) {
        int i = 5;
        int j = 10;

        swap(i, j);
        
        System.out.printf("out of swap function: %d, %d", i, j);
    }
}
