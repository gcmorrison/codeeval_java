import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/10.
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
        if (line == null || line.trim().length() == 0) {
            return;
        }

        handleInput(line);
    }

    private void handleInput(String line) {
        String[] values = line.split(",");
        System.out.println(values[0].lastIndexOf(values[1]));
    }
}
