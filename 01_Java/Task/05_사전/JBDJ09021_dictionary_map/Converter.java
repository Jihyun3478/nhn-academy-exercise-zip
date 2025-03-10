import java.util.*;

public class Converter {
    public static Map<Integer, Word> convertToWords() {
        List<String> fileLines = FileReaders.read();
        Map<Integer, Word> words = new HashMap<>();

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
            words.put(Integer.parseInt(split[0]), new Word(split[1], meanings));
        }
        return words;
    }
}
