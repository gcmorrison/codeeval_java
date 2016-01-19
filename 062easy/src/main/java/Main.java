import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/12.
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
        int[] values = parseLine(line);
        System.out.println(calculateMod(values[0], values[1]));
    }

    int[] parseLine(String line) {
        String[] split = line.split(",");
        int[] parameters = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            parameters[i] = Integer.parseInt(split[i]);
        }

        return parameters;
    }

    int calculateMod(int value, int mod) {
        double div = value / (double) mod;
        return (int) Math.round((div - (Math.floor(div))) * mod);
    }
}
