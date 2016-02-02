import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/27.
 */
public class Main {

    private int numberStart, numberEnd;

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
        System.out.println(compressSequence(line));
    }

    public String compressSequence(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        resetState();

        String compressed = "";
        int sequenceCount = 0;
        String currentNumber, previousNumber = null;

        do {
            currentNumber = getNextNumber(input);
            if (currentNumber.equals(previousNumber)) {
                sequenceCount++;
            } else if (sequenceCount > 0) {
                compressed += sequenceCount + " " + previousNumber + " ";
                sequenceCount = 1;
            } else {
                // First number
                sequenceCount = 1;
            }
            previousNumber = currentNumber;
        } while (numberEnd > -1);

        // Add last number in sequence
        compressed += sequenceCount + " " + previousNumber;

        return compressed;
    }

    private String getNextNumber(String input) {
        String nextNumber;

        numberEnd = input.indexOf(' ', numberStart);
        if (numberEnd == -1) {
            nextNumber = input.substring(numberStart);
        } else {
            nextNumber = input.substring(numberStart, numberEnd);
        }
        numberStart = numberEnd + 1;

        return nextNumber;
    }

    private void resetState() {
        numberStart = 0;
        numberEnd = 0;
    }

}
