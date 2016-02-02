import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/25.
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
        System.out.println(extractHiddenAndVisibleDigits(line));
    }

    public String extractHiddenAndVisibleDigits(String input) {
        if (input == null || input.length() == 0) {
            return "NONE";
        }

        String result = "";

        for (char letter : input.toCharArray()) {
            if (isVisibleDigit(letter)) {
                result += letter;
            } else if (isHiddenDigit(letter)) {
                result += letter - 'a';
            }
        }

        return result.length() > 0 ? result : "NONE";
    }

    private boolean isVisibleDigit(char letter) {
        return 0 <= letter - '0' && letter - '0' <= 9;
    }

    private boolean isHiddenDigit(char letter) {
        return 0 <= letter - 'a' && letter - 'a' <= 9;
    }
}
