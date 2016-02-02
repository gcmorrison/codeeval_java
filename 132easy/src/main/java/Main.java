import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/01.
 */
public class Main {
    private int elementStart, elementEnd;

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
        System.out.println(findMajorElement(line));
    }

    public String findMajorElement(String input) {
        if (input == null || input.length() == 0) {
            return "None";
        }

        resetState();

        short[] counts = new short[101]; // Number ranges 0-100
        short numberOfElements = 0, highestCount = 0;
        byte highestCountIndex = 0;

        byte element;
        while (elementEnd > -1) {
            element = getNextElement(input);
            numberOfElements++;
            counts[element]++;

            if (counts[element] > highestCount) {
                highestCount = counts[element];
                highestCountIndex = element;
            }
        }

        return (counts[highestCountIndex] >= numberOfElements / 2) ? String.valueOf(highestCountIndex) : "None";
    }

    private void resetState() {
        elementStart = 0;
        elementEnd = 0;
    }

    private byte getNextElement(String input) {
        byte element;

        elementEnd = input.indexOf(',', elementStart);
        if (elementEnd == -1) {
            element = Byte.valueOf(input.substring(elementStart));
        } else {
            element = Byte.valueOf(input.substring(elementStart, elementEnd));
        }
        elementStart = elementEnd + 1;

        return element;
    }

}
