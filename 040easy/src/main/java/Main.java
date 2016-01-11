import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/11.
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
        System.out.println(isSelfDescribingNumber(line) ? 1 : 0);
    }

    boolean isSelfDescribingNumber(String number) {
        char[] chars = number.toCharArray();
        short[] describe = buildDescribingArray(chars);

        boolean isSelfDescribing = true;
        int i = 0;
        while (isSelfDescribing && i < number.length()) {
            isSelfDescribing = isSelfDescribing && describe[i] == (chars[i] - '0');
            i++;
        }

        return isSelfDescribing;
    }

    short[] buildDescribingArray(char[] chars) {
        short[] describe = new short[10];
        int index;

        for (char c : chars) {
            index = 0;
            switch (c) {
                case '9':
                    index++;
                case '8':
                    index++;
                case '7':
                    index++;
                case '6':
                    index++;
                case '5':
                    index++;
                case '4':
                    index++;
                case '3':
                    index++;
                case '2':
                    index++;
                case '1':
                    index++;
            }
            describe[index]++;
        }

        return describe;
    }
}
