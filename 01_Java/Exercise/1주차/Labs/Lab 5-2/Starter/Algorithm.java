import java.util.Arrays;

public class Algorithm {
    public static int sigma(int init, int start, int end, int step) {
        return accumulate(new Adder(), 0, start, end, step);
    }

    public static int pi(int init, int start, int end, int step) {
        return accumulate(new Multiplier(), 1, start, end, step);
    }

    public static int accumulate(Adder binder, int init, int start, int end, int step) {
        int result = init;
        for(int i = start; i <= end; i+=step) {
            result = binder.apply(i, result);
        }
        return result;
    }

    public static int accumulate(Multiplier binder, int init, int start, int end, int step) {
        int result = init;
        for(int i = start; i <= end; i+=step) {
            result = binder.apply(i, result);
        }
        return result;
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[][][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                for(int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static String convert(char[] c) {
        String answer = String.valueOf(c[0]);
        for(int i = 0; i < c.length-1; i++) {
            if(c[i] == ' ') {
                answer += String.valueOf(c[i+1]);
            }
        }
        return answer.toUpperCase();
    }

    //
    // To-do add overloaded accumulate method here
    //

    public static void main(String[] args) {
        char[] c = "international business machine".toCharArray();
        System.out.println(convert(c));
    }
}