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
        System.out.println(parseListsAndMultiply(line));
    }

    public String parseListsAndMultiply(String input) {
        if (input == null || input.length() == 0 || !input.contains("|")) {
            return null;
        }

        String multipliedOutput = "";

        int leftIndex, rightIndex;
        int nextLeft = 0, nextRight = input.indexOf('|') + 2;
        while (nextRight != -1) {
            leftIndex = nextLeft;
            rightIndex = nextRight;

            nextRight = input.indexOf(' ', rightIndex);
            nextLeft = input.indexOf(' ', leftIndex);

            if (nextRight == -1) {
                multipliedOutput += " " + multiplyNumbers(input.substring(leftIndex, nextLeft), input.substring(rightIndex));
            } else {
                multipliedOutput += " " + multiplyNumbers(input.substring(leftIndex, nextLeft++), input.substring(rightIndex, nextRight++));
            }
        }

        return multipliedOutput.trim();
    }

    private String multiplyNumbers(String number1, String number2) {
        return String.valueOf(Integer.valueOf(number1) * Integer.valueOf(number2));
    }

}
