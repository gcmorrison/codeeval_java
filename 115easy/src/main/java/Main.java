import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/22.
 */
public class Main {
    int lastStart, lastEnd;
    String nextWord;

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
        System.out.println(separateContent(line));
    }

    public String separateContent(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        resetStates();

        String words = "";
        String numbers = "";
        while (hasNext()) {
            stepToNextWord(input);

            if (isNumber(nextWord)) {
                numbers += nextWord + ",";
            } else {
                words += nextWord + ",";
            }
        }

        return mergeContent(performCleanup(words), performCleanup(numbers));
    }

    private void resetStates() {
        lastStart = 0;
        lastEnd = 0;
        nextWord = null;
    }

    private boolean hasNext() {
        return lastEnd > -1;
    }

    private void stepToNextWord(String input) {
        lastEnd = input.indexOf(',', lastStart);

        if (lastEnd == -1) {
            nextWord = input.substring(lastStart);
        } else {
            nextWord = input.substring(lastStart, lastEnd);
        }

        lastStart = lastEnd + 1;
    }

    private boolean isNumber(String current) {
        return current.length() > 0 && current.charAt(0) - '0' <= 9;
    }

    private String performCleanup(String cleanup) {
        if (cleanup.endsWith(",")) {
            cleanup = cleanup.substring(0, cleanup.length() - 1);
        }

        return cleanup;
    }

    private String mergeContent(String words, String numbers) {
        if (words.length() != 0 && numbers.length() != 0) {
            numbers = "|" + numbers;
        }

        return words + numbers;
    }
}
