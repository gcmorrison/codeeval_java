import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/04.
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
        System.out.println(calculateAngle(line));
    }

    public String calculateAngle(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        float number;
        try {
            number = Float.valueOf(input);
        } catch (NumberFormatException e) {
            // NaN
            return null;
        }

        short[] components = splitIntoComponents(number);

        return String.format("%d.%02d'%02d\"", components[0], components[1], components[2]);
    }

    private short[] splitIntoComponents(float number) {
        short[] components = new short[3];

        components[0] = (short) Math.floor(number);

        float current = (number - components[0]) * 60;
        components[1] = (short) Math.floor(current);

        current = (current - components[1]) * 60;
        components[2] = (short) Math.floor(current);

        return components;
    }
}
