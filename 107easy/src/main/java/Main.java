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
        System.out.println(determineShortestRepetition(line));
    }

    public int determineShortestRepetition(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int period = 1;
        while (period < input.length()) {
            if (isRepeatingSequence(input, input.substring(0, period))) {
                break;
            }
            period++;
        }

        return period;
    }

    private boolean isRepeatingSequence(String input, String sequence) {
        return input.endsWith(sequence) && input.startsWith(sequence) && input.replace(sequence, "").length() == 0;
    }
}
