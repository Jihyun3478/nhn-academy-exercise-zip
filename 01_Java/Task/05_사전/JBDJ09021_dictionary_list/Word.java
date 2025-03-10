import java.util.*;

public class Word {
    private int index;
    private String word;
    private List<String> meaning;

    public Word(int index, String word, List<String> meaning) {
        this.index = index;
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "번호 : " + index + ", 단어 : " + word + ", 뜻 : " + String.join(", ", meaning);
    }
}
