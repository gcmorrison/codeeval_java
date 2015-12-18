import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2015/12/18.
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
        String[] numbers = line.split(",");
        int baseNumber = Integer.valueOf(numbers[0]);
        int multipleNumber = Integer.valueOf(numbers[1]);

        int number = multipleNumber;
        while (number < baseNumber) {
            number += multipleNumber;
        }

        return number;
    }
}
