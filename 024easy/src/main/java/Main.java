import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/08.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader buffer = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        int sum = 0;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            sum += main.getNextValue(line);
        }

        System.out.println(main.printResult(sum));
    }

    int getNextValue(String line) {
        if (line == null || line.trim().length() == 0) {
            return 0;
        }

        return Integer.parseInt(line);
    }

    String printResult(int answer) {
        return String.valueOf(answer);
    }

}
