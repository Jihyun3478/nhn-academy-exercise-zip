import java.util.*;

public class Anagram {
    public static String convertToString(char[] c) {
        String temp = "";
        for(int i = 0; i < c.length; i++) {
            temp += c[i];
        }
        return temp;
    }

    public static String removeAndLower(String str) {
        str = str.replaceAll(" ", "");
        str = str.toLowerCase();
        return str;
    }

	public static String[] sort(String[] str) {
		Arrays.sort(str, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
        return str;
	}

    public static boolean isSame(String[] str1, String[] str2) {
        String s1 = Arrays.toString(str1);
        String s2 = Arrays.toString(str2);
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        char[] c1 = "Tom Marvolo Riddle".toCharArray();
        char[] c2 = "I am Lord Voldemort".toCharArray();

        String str1 = convertToString(c1);
        String str2 = convertToString(c2);

        String organizeStr1 = removeAndLower(str1);
        String organizeStr2 = removeAndLower(str2);

        String[] sortS1 = sort(organizeStr1.split(""));
        String[] sortS2 = sort(organizeStr2.split(""));

        if(isSame(sortS1, sortS2)) {
            System.out.printf("%s and %s is same", Arrays.toString(sortS1), Arrays.toString(sortS2));
        } else {
            System.out.printf("%s and %s is different", Arrays.toString(sortS1), Arrays.toString(sortS2));
        }
    }
}