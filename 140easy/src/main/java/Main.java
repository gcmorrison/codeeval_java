import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/04.
 */
public class Main {
    private int dataStart, dataEnd, indexStart, indexEnd;

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
        System.out.println(recoverData(line));
    }

    public String recoverData(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        resetState();

        String data = getDataContent(input);
        String indices = getIndexContent(input);
        int wordCount = getWordCount(data);

        String[] recovered = new String[wordCount];

        String word;
        int index;
        while (dataEnd > -1) {
            word = getNextWord(data);
            index = getNextIndex(indices, recovered);

            if (recovered[index] != null) {
                recovered[index] += " " + word;
            } else {
                recovered[index] = word;
            }
        }

        return buildStringFromRecovered(recovered, data.length());
    }

    private void resetState() {
        dataStart = 0;
        dataEnd = 0;
        indexStart = 0;
        indexEnd = 0;
    }

    private String getDataContent(String input) {
        return input.substring(0, input.indexOf(';')).trim();
    }

    private String getIndexContent(String input) {
        return input.substring(input.indexOf(';') + 1).trim();
    }

    private int getWordCount(String data) {
        int count = 0;
        for (char letter : data.toCharArray()) {
            if (letter == ' ') {
                count++;
            }
        }

        return data.length() > 0 ? count + 1 : 0;
    }

    private String getNextWord(String data) {
        String word;

        dataEnd = data.indexOf(' ', dataStart);
        if (dataEnd == -1) {
            word = data.substring(dataStart);
        } else {
            word = data.substring(dataStart, dataEnd);
        }
        dataStart = dataEnd + 1;

        return word;
    }

    private int getNextIndex(String indices, String[] recovered) {
        if (indexStart < 0) {
            return getNextUnassignedIndex(recovered);
        }

        String word;

        indexEnd = indices.indexOf(' ', indexStart);
        if (indexEnd == -1) {
            word = indices.substring(indexStart);
            indexEnd = Integer.MIN_VALUE;
        } else {
            word = indices.substring(indexStart, indexEnd);
        }
        indexStart = indexEnd + 1;

        // Convert 1-based to 0-based
        int index = word.length() > 0 ? Integer.valueOf(word) - 1 : -1;
        return index >= 0 ? index : getNextUnassignedIndex(recovered);
    }

    private int getNextUnassignedIndex(String[] recovered) {
        for (int i = 0; i < recovered.length; i++) {
            if (recovered[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private String buildStringFromRecovered(String[] recovered, int charCount) {
        if (recovered == null || recovered.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder(charCount);
        for (String word : recovered) {
            if (word != null) {
                sb.append(" ").append(word);
            }
        }

        return sb.toString().trim();
    }
}
