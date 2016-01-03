import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/03.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(main.printResult(line));
        }
    }

    int printResult(String line) {
        int iteration = Integer.valueOf(line);

        return calculateFibonacci(iteration);
    }

    private int calculateFibonacci(int max) {
        if (max < 2) {
            return max;
        }

        return calculateFibonacci(max - 1) + calculateFibonacci(max - 2);
    }
}
