import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/22.
 */
public class Main {

    int lastStart, lastEnd;
    String currentLetter;

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
        System.out.println(decodeMorseCode(line));
    }

    public String decodeMorseCode(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        resetStates();
        String decoded = "";
        while (hasNext()) {
            stepToNext(input);
            decoded += decodeLetter(currentLetter);
        }

        return decoded;
    }

    private void resetStates() {
        lastStart = 0;
        lastEnd = 0;
        currentLetter = null;
    }

    private boolean hasNext() {
        return lastEnd > -1;
    }

    private void stepToNext(String input) {
        lastEnd = input.indexOf(' ', lastStart);

        if (lastEnd == lastStart) {
            currentLetter = " ";
        } else if (lastEnd == -1) {
            currentLetter = input.substring(lastStart);
        } else {
            currentLetter = input.substring(lastStart, lastEnd);
        }

        lastStart = lastEnd + 1;
    }

    private char decodeLetter(String letter) {
        if (letter.equals(" ")) {
            return ' ';
        } else {
            switch (letter.length()) {
                case 1:
                    return handleOneUnitLetter(letter);
                case 2:
                    return handleTwoUnitLetter(letter);
                case 3:
                    return handleThreeUnitLetter(letter);
                case 4:
                    return handleFourUnitLetter(letter);
                case 5:
                    return handleNumberLetter(letter);
            }
        }
        return ' ';
    }

    private char handleOneUnitLetter(String letter) {
        return letter.charAt(0) == '.' ? 'E' : 'T';
    }

    private char handleTwoUnitLetter(String letter) {
        if (letter.charAt(0) == '.') {
            return letter.charAt(1) == '.' ? 'I' : 'A';
        } else {
            return letter.charAt(1) == '.' ? 'N' : 'M';
        }
    }

    private char handleThreeUnitLetter(String letter) {
        if (letter.charAt(0) == '.') {
            // Possibilities: R/S/U/W
            if (letter.charAt(1) == '.') {
                return letter.charAt(2) == '.' ? 'S' : 'U';
            }
            return letter.charAt(2) == '.' ? 'R' : 'W';
        } else {
            // Possibilities: D/G/K/O
            if (letter.charAt(1) == '.') {
                return letter.charAt(2) == '.' ? 'D' : 'K';
            }
            return letter.charAt(2) == '.' ? 'G' : 'O';
        }
    }

    private char handleFourUnitLetter(String letter) {
        if (letter.charAt(0) == '.') {
            // Possibilities: H/V/F/?/L/?/P/J
            if (letter.charAt(1) == '.') {
                // Possibilities: H/V/F/?
                if (letter.charAt(2) == '.') {
                    return letter.charAt(3) == '.' ? 'H' : 'V';
                }
                return letter.charAt(3) == '.' ? 'F' : '?';
            } else {
                // Possibilities: L/?/P/J
                if (letter.charAt(2) == '.') {
                    return letter.charAt(3) == '.' ? 'L' : '?';
                }
                return letter.charAt(3) == '.' ? 'P' : 'J';
            }
        } else {
            // Possibilities: B/X/C/Y/Z/Q/?/?
            if (letter.charAt(1) == '.') {
                // Possibilities: B/X/C/Y
                if (letter.charAt(2) == '.') {
                    return letter.charAt(3) == '.' ? 'B' : 'X';
                }
                return letter.charAt(3) == '.' ? 'C' : 'Y';
            } else {
                // Possibilities: Z/Q/?/?
                if (letter.charAt(2) == '.') {
                    return letter.charAt(3) == '.' ? 'Z' : 'Q';
                }
                return letter.charAt(3) == '.' ? '?' : '?';
            }
        }
    }

    private char handleNumberLetter(String letter) {
        boolean startsWithDot = letter.charAt(0) == '.';

        for (int i = 1; i < letter.length(); i++) {
            if (startsWithDot && letter.charAt(i) != '.') {
                return (char) (i + '0');
            } else if (!startsWithDot && letter.charAt(i) != '-') {
                return (char) (i + '5');
            }
        }

        return startsWithDot ? '5' : '0';
    }
}
