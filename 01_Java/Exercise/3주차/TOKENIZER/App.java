import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) {
        List<Token> list = new ArrayList<>();
        String code = "interface List<T> { { public static void main(String[] args) } }";

        String[] words = code.split(" ");

        for (String word : words) {
            if (word.equals("class") || word.equals("abstract") || word.equals("interface")) {
                list.add(new ClassToken(word));
            } else if (word.equals("public") || word.equals("static") || word.equals("void")) {
                list.add(new KeywordToken(word));
            } else if (word.equals("{") || word.equals("}")) {
                list.add(new LineToken(word));
            } else {
                list.add(new NullToken(word));
            }
        }

        TokenVisitor visitor = new ClassTokenVisitor();
        for (Token t : list) {
            System.out.println(t.accept(visitor));
        }
    }
}
