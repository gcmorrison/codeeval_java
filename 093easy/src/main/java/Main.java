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
        char[] letters = line.toCharArray();

        if ('a' <= letters[0] && letters[0] <= 'z') {
            System.out.print((char) (letters[0] + ('A' - 'a')));
        } else {
            System.out.print(letters[0]);
        }

        for (int i = 1; i < letters.length; i++) {
            System.out.print(letters[i]);
            if (letters[i] == ' ' && 'a' <= letters[i + 1] && letters[i + 1] <= 'z') {
                System.out.print((char) (letters[i + 1] + ('A' - 'a')));
                i++;
            }
        }
        System.out.println();
    }
}
