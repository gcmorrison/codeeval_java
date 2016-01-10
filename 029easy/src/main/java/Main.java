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
            System.out.println("");
            return;
        }

        System.out.println(printUniqueNumbers(line));
    }

    String printUniqueNumbers(String line) {
        return getUniqueOnly(parseCommaSeparated(line));
    }

    private String getUniqueOnly(String[] values) {
        String result = "", lastValue = null;

        for (String value : values) {
            if (!value.equals(lastValue)) {
                result += "," + value;
                lastValue = value;
            }
        }

        return result.replaceFirst("^,", "");
    }

    String[] parseCommaSeparated(String line) {
        return line.split(",");
    }

}
