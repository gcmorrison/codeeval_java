import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/04.
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
        System.out.println(calculateRatios(line));
    }

    public String calculateRatios(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        byte lowerCount = 0;
        byte upperCount = 0;

        for (char letter : input.toCharArray()) {
            if ('a' <= letter && letter <= 'z') {
                lowerCount++;
            } else if ('A' <= letter && letter <= 'Z') {
                upperCount++;
            }
        }

        return String.format("lowercase: %.2f uppercase: %.2f", (lowerCount / (float) input.length()) * 100, (upperCount / (float) input.length()) * 100);
    }

}
