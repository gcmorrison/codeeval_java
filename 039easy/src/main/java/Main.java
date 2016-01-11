import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by campbell on 2016/01/11.
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
        System.out.println(isHappyNumber(line) ? "1" : "0");
    }

    boolean isHappyNumber(String number) {
        HashMap<Integer, Object> found = new HashMap<>();

        int sumOfSquares = Integer.parseInt(number);
        while (sumOfSquares != 1 && sumOfSquares != 0) {
            sumOfSquares = calculateSumOfSquares(sumOfSquares);
            if (found.containsKey(sumOfSquares)) {
                break;
            }
            found.put(sumOfSquares, null);
        }

        found.clear();
        return sumOfSquares == 1;
    }

    private int calculateSumOfSquares(int sumOfSquares) {
        int sum = 0;

        while (sumOfSquares > 0) {
            sum += Math.pow(sumOfSquares % 10, 2);
            sumOfSquares = sumOfSquares / 10;
        }

        return sum;
    }
}
