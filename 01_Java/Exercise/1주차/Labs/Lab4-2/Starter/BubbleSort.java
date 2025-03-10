public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 4, 9, 1, 12};
        int temp = 0;

        System.out.print("before sort: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        /* 프로시저 */
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    // temp = array[i];
                    // array[i] = array[j];
                    // array[j] = temp;
                    Swap.swap(array[i], array[j]);
                }
            }
        }

        System.out.print("after sort: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
