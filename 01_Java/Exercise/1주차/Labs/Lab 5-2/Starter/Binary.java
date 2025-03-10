import java.util.*;

public class Binary {
    public static String decimalToBinary(String s) {
        int decimal = Integer.parseInt(s);
        String temp = "";

        while(decimal != 0) {
            int remain = decimal % 2;
            decimal = decimal / 2;
            temp += remain;
        }

        String result = "";
        for(int i = temp.length()-1; i >= 0; i--) {
            result += temp.charAt(i);
        }
        return result;
    }

    public static int binaryToDecimal(String s) {
        String temp = "";
        for(int i = s.length()-1; i >= 0; i--) {
            temp += s.charAt(i);
        }

        String[] split = temp.split("");
        int result = 0;
        for(int i = 0; i < split.length; i++) {
            if(split[i].equals("1")) {
                result += Math.pow(2, i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String decimal = "10";
        System.out.println(decimalToBinary(decimal));
        String binary = "1010";
        System.out.println(binaryToDecimal(binary));
    }
}
