public class Sample {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] array2 = array;

        array2[1] = 10;

        System.out.println(array[1]);
    }
}
