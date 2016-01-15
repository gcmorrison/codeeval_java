import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/15.
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
        String[] parts = line.split("\\|");
        String[] keys = parts[1].trim().split(" ");

        int index;
        for (int i = 0; i < keys.length; i++) {
            index = Integer.parseInt(keys[i]) - 1;
            if (index >= 0 && index < parts[0].length()) {
                System.out.print(parts[0].charAt(index));
            }
        }
        System.out.println();
    }

}
