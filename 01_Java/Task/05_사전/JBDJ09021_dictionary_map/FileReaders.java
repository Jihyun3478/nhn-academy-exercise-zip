import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * 파일 내용 읽기를 관리하는 클래스
 */
public class FileReaders {
    private static final String FILE_PATH = "words.txt";

    public static List<String> read() {
        List<String> fileLines = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                fileLines.add(fileLine);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File is not found from " + FILE_PATH);
        }
        return fileLines;
    }
}
