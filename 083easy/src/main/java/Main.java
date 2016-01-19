import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/01/14.
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
        System.out.println(calculateStringBeauty(line));
    }

    int calculateStringBeauty(String line) {
        if (line == null || line.trim().length() == 0) {
            return 0;
        }

        String orderedLine = orderStringByOccurrence(line);

        byte currentLetterScore = 27;
        char lastChar = 0;
        int score = 0;
        for (char letter : orderedLine.toCharArray()) {
            if (letter != lastChar) {
                currentLetterScore--;
                lastChar = letter;
            }
            score += currentLetterScore;
        }

        return score;
    }


    String orderStringByOccurrence(String line) {
        byte[] letterCount = buildLetterCount(line);

        int maxCount = findMaxCount(letterCount);

        String orderedString = "";
        int index = 0;
        while (maxCount > 0) {
            if (letterCount[index] == maxCount) {
                for (int count = 0; count < letterCount[index]; count++) {
                    orderedString += (char) (index + 'a');
                }
            }
            index++;
            if (index == letterCount.length) {
                index = 0;
                maxCount--;
            }
        }

        return orderedString;
    }

    private int findMaxCount(byte[] letterCount) {
        int maxCount = 0;

        for (byte count : letterCount) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    private byte[] buildLetterCount(String line) {
        byte[] letterCount = new byte[26];

        for (char letter : line.toCharArray()) {
            if ('A' <= letter && letter <= 'Z') {
                letter += 'a' - 'A';
            }

            if ('a' <= letter && letter <= 'z') {
                letterCount[letter - 'a']++;
            }
        }

        return letterCount;
    }
}
