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
        System.out.println(swapElements(line));
    }

    public String swapElements(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        if (!input.contains(":")) {
            return input;
        }

        String numberSequence = getNumberSequenceString(input);
        String swapSequence = getSwapSequenceString(input);

        if (swapSequence.isEmpty()) {
            return numberSequence;
        }

        return processSwapCommands(numberSequence, swapSequence);
    }

    private String getSwapSequenceString(String input) {
        return input.substring(input.indexOf(':') + 1).trim();
    }

    private String getNumberSequenceString(String input) {
        return input.substring(0, input.indexOf(':')).trim();
    }

    private String processSwapCommands(String numberSequence, String swapSequence) {
        String[] numbersList = buildSequence(numberSequence, ' ');
        String[] swapList = buildSequence(swapSequence, ',');

        applyAllSwapCommands(numbersList, swapList);

        return rebuildSequenceString(numbersList);
    }

    private String[] buildSequence(String sequence, char separator) {
        String[] separated = new String[countElements(sequence, separator)];

        int startIndex = 0, endIndex;
        for (int i = 0; i < separated.length; i++) {
            endIndex = sequence.indexOf(separator, startIndex);
            if (endIndex == -1) {
                separated[i] = sequence.substring(startIndex).trim();
                break;
            } else {
                separated[i] = sequence.substring(startIndex, endIndex).trim();
                startIndex = endIndex + 1;
            }
        }

        return separated;
    }

    private int countElements(String sequence, char separator) {
        byte count = 1;

        for (char letter : sequence.toCharArray()) {
            if (letter == separator) {
                count++;
            }
        }

        return count;
    }

    private void applyAllSwapCommands(String[] numbersList, String[] swapList) {
        for (String swap : swapList) {
            swap(numbersList, swap);
        }
    }

    private void swap(String[] numbersList, String swap) {
        int swapIndex1 = Integer.valueOf(swap.substring(0, swap.indexOf('-')));
        int swapIndex2 = Integer.valueOf(swap.substring(swap.indexOf('-') + 1));

        String temp = numbersList[swapIndex1];
        numbersList[swapIndex1] = numbersList[swapIndex2];
        numbersList[swapIndex2] = temp;
    }

    private String rebuildSequenceString(String[] numbersList) {
        String sequence = "";

        for (String number : numbersList) {
            sequence += " " + number;
        }

        return sequence.trim();
    }
}
