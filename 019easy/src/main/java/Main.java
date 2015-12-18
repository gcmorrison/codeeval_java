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

    String printResult(String line) {
        String[] numbers = line.split(",");

        int base = Integer.valueOf(numbers[0]);
        int pos1 = Integer.valueOf(numbers[1]) - 1;
        int pos2 = Integer.valueOf(numbers[2]) - 1;

        return (base & (1 << pos1)) >> pos1 == (base & (1 << pos2)) >> pos2 ? "true" : "false";
    }
}
