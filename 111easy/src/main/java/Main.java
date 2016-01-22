import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/20.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            main.printResult(line);
        }
    }

    void printResult(String line) {
        System.out.println(findLongestWord(line));
    }

    public String findLongestWord(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String longestWord = null;

        int lastWordEnd = 0, longestLength = 0;
        String word;
        for (int i = 0; i < input.length(); i++) {
            if (i == input.length() - 1) {
                word = input.substring(lastWordEnd);
            } else if (input.charAt(i) == ' ') {
                word = input.substring(lastWordEnd, i);
            } else {
                continue;
            }

            if (word.length() > longestLength) {
                longestLength = word.length();
                longestWord = word;
            }
            lastWordEnd = lastWordEnd + word.length() + 1;
        }

        return longestWord;
    }
}
