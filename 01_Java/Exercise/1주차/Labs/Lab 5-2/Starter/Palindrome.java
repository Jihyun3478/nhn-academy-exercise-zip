public class Palindrome {
    public static boolean isPalindrome(String word) {
        boolean result = false;

        if(word.length() % 2 == 0) {
            String splitWord1 = word.substring(0, word.length()/2);
            String temp = word.substring(word.length()/2, word.length());

            String splitWord2 = "";
            for(int i = temp.length()-1; i >= 0; i--) {
                splitWord2 += temp.charAt(i);
            }

            result = isSame(splitWord1, splitWord2);
        } else if(word.length() % 2 == 1) {
            String splitWord1 = word.substring(0, word.length()/2);
            String temp = word.substring(word.length()/2+1, word.length());

            String splitWord2 = "";
            for(int i = temp.length()-1; i >= 0; i--) {
                splitWord2 += temp.charAt(i);
            }

            result = isSame(splitWord1, splitWord2);
        }
        return result;
    }

    public static boolean isSame(String str1, String str2) {
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        String word = "토마옹마토";
        boolean result = isPalindrome(word);

        if(result) {
            System.out.printf("%s is palindrome", word);
        } else {
            System.out.printf("%s is not palindrome", word);
        }
    }
}
