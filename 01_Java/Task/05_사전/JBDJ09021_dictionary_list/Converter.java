import java.util.*;

public class Converter {
    public static List<Word> convertToWords() {
        List<String> fileLines = FileReaders.read();
        List<Word> words = new ArrayList<>();

        for (String fileLine : fileLines) {
            fileLine = fileLine.replace(".", "");
            fileLine = fileLine.replace(",", "");
            fileLine = fileLine.replace("\t", " ");
            fileLine = fileLine.replace("  ", " ");

            String[] split = fileLine.split(" ");
            List<String> meanings = new ArrayList<>();

            for (int i = 2; i < split.length; i++) {
                meanings.add(split[i]);
            }
            words.add(new Word(Integer.parseInt(split[0]), split[1], meanings));
        }
        return words;
    }
}
