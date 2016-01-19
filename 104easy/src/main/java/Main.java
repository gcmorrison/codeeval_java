import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Campbell on 2016/01/19.
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
        System.out.println(convertWordsToNumber(line));
    }

    public String convertWordsToNumber(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        String[] words = separateWords(input);
        String output = "";

        for (String word : words) {
            output += getCorrespondingNumber(word);
        }

        return output;
    }

    private String getCorrespondingNumber(String word) {
        switch (word.charAt(0)) {
            case 'z':
                return "0";
            case 'o':
                return "1";
            case 't':
                if (word.charAt(1) == 'w') {
                    return "2";
                } else if (word.charAt(1) == 'h') {
                    return "3";
                }
            case 'f':
                if (word.charAt(1) == 'o') {
                    return "4";
                } else if (word.charAt(1) == 'i') {
                    return "5";
                }
            case 's':
                if (word.charAt(1) == 'i') {
                    return "6";
                } else if (word.charAt(1) == 'e') {
                    return "7";
                }
            case 'e':
                return "8";
            case 'n':
                return "9";
        }

        return "";
    }

    private String[] separateWords(String input) {
        return input.split(";");
    }
}
