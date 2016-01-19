import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/14.
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
        System.out.println(isArmstrongNumber(line) ? "True" : "False");
    }

    boolean isArmstrongNumber(String number) {
        if (number.length() == 1) {
            // Anything^1 = itself, so it'll always be an armstrong number
            return true;
        }

        return Integer.parseInt(number) == calculateSumOfNthPowers(number);
    }

    private int calculateSumOfNthPowers(String number) {
        int length = number.length();
        int sum = 0;

        for (char digit : number.toCharArray()) {
            sum += (int) Math.pow(digit - '0', length);
        }

        return sum;
    }
}
