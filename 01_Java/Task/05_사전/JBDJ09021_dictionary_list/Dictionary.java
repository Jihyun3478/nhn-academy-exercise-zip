import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Words words = new Words(Converter.convertToWords());

        System.out.print("검색할 단어를 입력하세요: ");
        String search = sc.next();
        System.out.println();

        for (Word word : words.getWords()) {
            if (word.getWord().equals(search)) {
                System.out.println(word.toString());
            }
        }
    }
}
