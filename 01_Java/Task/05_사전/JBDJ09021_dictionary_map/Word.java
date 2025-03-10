import java.util.*;

public class Word {
    private String word;
    private List<String> meaning;

    public Word(String word, List<String> meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "단어 : " + word + ", 뜻 : " + String.join(", ", meaning);
    }
}
