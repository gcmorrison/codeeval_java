import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class is the template that all solutions should be based off of
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
        return "";
    }
}
