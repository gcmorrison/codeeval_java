import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/01.
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
        System.out.println(splitAndCalculate(line));
    }

    public int splitAndCalculate(String input) {
        if (input == null || input.length() == 0) {
            return -1;
        }

        int splitIndex = input.indexOf(' ');
        if (splitIndex == -1) {
            return Integer.valueOf(input.substring(0));
        }

        String leftOp = "0", rightOp = "0";
        char operator = ' ';
        for (int i = splitIndex + 1; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '-':
                case '+':
                    operator = input.charAt(i);
                    break;
                default:
                    if (operator == ' ') {
                        leftOp += input.charAt(input.charAt(i) - 'a');
                    } else {
                        rightOp += input.charAt(input.charAt(i) - 'a');
                    }
                    break;
            }
        }

        return calculate(leftOp, rightOp, operator);
    }

    private int calculate(String leftOp, String rightOp, char operator) {
        int left = Integer.valueOf(leftOp);
        int right = Integer.valueOf(rightOp);

        switch (operator) {
            case '-':
                return left - right;
            default:
                return left + right;
        }
    }
}
