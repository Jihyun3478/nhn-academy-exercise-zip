import java.lang.*;

public class Utilities {
    public static int max(int i, int j) {
        if (i > j)
            return i;
        else 
            return j;
    }

    public static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static int swap2(int i, int j) {
        return i;
    }

    public static String reverseString(String s) {
        // StringBuilder sb = new StringBuilder();
        // String temp = "";
        // for(int i = s.length()-1; i >= 0; i--) {
        //     sb.append(s.charAt(i));
        // }
        // return sb.toString();
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}

class Test {
    public static void main(String[] args) {
        String result = Utilities.reverseString("apple");
        System.out.println(result);
    }
}