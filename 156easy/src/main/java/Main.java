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
        System.out.println(applyRollerCoasterCase(line));
    }

    public String applyRollerCoasterCase(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        boolean toUpper = true;
        String output = "";
        for (char letter : input.toCharArray()) {
            if (shouldApplyTransform(letter)) {
                output += applyCase(letter, toUpper);
                toUpper = !toUpper;
            } else {
                output += letter;
            }
        }

        return output;
    }

    private boolean shouldApplyTransform(char letter) {
        return isLowerCase(letter) || isUpperCase(letter);
    }

    private boolean isUpperCase(char letter) {
        return 'A' <= letter && letter <= 'Z';
    }

    private boolean isLowerCase(char letter) {
        return 'a' <= letter && letter <= 'z';
    }

    private char applyCase(char letter, boolean toUpper) {
        if (toUpper && isLowerCase(letter)) {
            return (char) (letter + ('A' - 'a'));
        } else if (!toUpper && isUpperCase(letter)) {
            return (char) (letter - ('A' - 'a'));
        }

        return letter;
    }

}
