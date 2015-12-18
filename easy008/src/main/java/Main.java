import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2015/12/18.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main reverseWords = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            if (line.length() == 0) {
                continue;
            }

            System.out.println(reverseWords.reverseWords(line));
        }
    }

    String reverseWords(String line) {
        String[] words = line.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);

        return sb.toString();
    }
}
