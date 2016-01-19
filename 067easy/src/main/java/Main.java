import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/14.
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
        System.out.println(convertHexToDecimal(line));
    }

    int convertHexToDecimal(String hex) {
        int decimal = 0;
        for (char digit : hex.toCharArray()) {
            decimal = (decimal << 4) | convertHexCharToDecimal(digit);
        }
        return decimal;
    }

    private int convertHexCharToDecimal(char digit) {
        if ('0' <= digit && digit <= '9') {
            return digit - '0';
        } else if ('a' <= digit && digit <= 'f') {
            return 10 + digit - 'a';
        } else {
            throw new IllegalArgumentException("denied!");
        }
    }
}
