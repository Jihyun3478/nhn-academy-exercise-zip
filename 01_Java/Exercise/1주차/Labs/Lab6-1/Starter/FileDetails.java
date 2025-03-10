import java.io.*;

public class FileDetails {
    public static void summerize(char[] contents) {
        int consonant = 0, vowel = 0, lines = 0;
        String vowels = "AEIOUaeiou";

        for (char c : contents) {
            if (Character.isLetter(c)) {
                if(vowels.indexOf(c) != -1) {
                    vowel++;
                } else {
                    consonant++;
                }
            } else if(c == '\n') {
                lines++;
            }
        }
        System.out.println("총 문자 수: " + contents.length);
        System.out.println("모음 수: " + vowel);
        System.out.println("자음 수: " + consonant);
        System.out.println("줄 수: " + lines);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileDetails FileName");
            return;
        }
        String fileName = args[0];

        File file = new File(fileName);
        try (FileInputStream stream = new FileInputStream(file)) {
            char[] contents = new char[(int) file.length()];

            for (int i = 0; i < contents.length; i++) {
                contents[i] = (char) stream.read(); 
            }
            summerize(contents);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}