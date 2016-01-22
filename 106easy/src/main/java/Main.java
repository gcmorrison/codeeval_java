import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/20.
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
        System.out.println(convertNumberToRomanNumeral(line));
    }

    public String convertNumberToRomanNumeral(String input) {
        if (!isValidNumberInput(input)) {
            return null;
        }

        String romanNumeral = "";
        for (int i = 0; i < input.length(); i++) {
            romanNumeral += numeralFor(input.charAt(i), input.length() - i);
        }

        return romanNumeral;
    }

    private boolean isValidNumberInput(String input) {
        return input != null && input.length() > 0 && input.replaceAll("0", "").length() > 0;
    }

    private String numeralFor(char digit, int digitPosition) {
        String symbolForPosition = getSymbolForPosition(digitPosition);
        String numeral = symbolForPosition;

        switch (digit) {
            case '3':
                numeral += symbolForPosition;
            case '2':
                numeral += symbolForPosition;
            case '1':
                break;
            case '4':
                numeral += getSubsequentSymbolForPosition(digitPosition);
                break;
            case '5':
            case '6':
            case '7':
            case '8':
                numeral = getSubsequentSymbolForPosition(digitPosition) + (numeralFor((char) (digit - 5), digitPosition));
                break;
            case '9':
                numeral += numeralFor('1', digitPosition + 1);
                break;
            default:
                numeral = "";
        }

        return numeral;
    }

    private String getSymbolForPosition(int digitPosition) {
        switch (digitPosition) {
            case 1:
                return "I";
            case 2:
                return "X";
            case 3:
                return "C";
            case 4:
                return "M";
        }
        return "";
    }

    private String getSubsequentSymbolForPosition(int digitPosition) {
        switch (digitPosition) {
            case 1:
                return "V";
            case 2:
                return "L";
            case 3:
                return "D";
        }
        return "";
    }
}
