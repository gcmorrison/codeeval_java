import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2015/12/18.
 */
public class Main {

    public Main(File fileToRead) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(fileToRead));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            reverseWords(line);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main(new File(args[0]));
    }

    private void reverseWords(String line) {
        if (line == null || line.length() == 0) {
            return;
        }

        String[] words = line.split(" ");
        for (int i = words.length - 1; i > 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println(words[0]);
    }
}
