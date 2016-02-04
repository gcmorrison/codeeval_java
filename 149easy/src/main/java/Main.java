import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by campbell on 2016/02/04.
 */
public class Main {
    int sequenceStart;
    int sequenceEnd;

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
        System.out.println(parse(line));
    }

    public long parse(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        resetState();

        long result = 0;

        String flag, sequence;
        while (sequenceEnd > -1) {
            flag = getNextSequence(input);
            sequence = getNextSequence(input);

            result = handleSequence(result, sequence, flag.equals("00"));
        }

        return result;
    }

    private long handleSequence(long result, String sequence, boolean isOnes) {
        for (int i = 0; i < sequence.length(); i++) {
            result = (result << 1) | (isOnes ? 1 : 0);
        }
        return result;
    }

    private void resetState() {
        sequenceStart = 0;
        sequenceEnd = 0;
    }

    private String getNextSequence(String input) {
        String sequence;

        sequenceEnd = input.indexOf(' ', sequenceStart);
        if (sequenceEnd == -1) {
            sequence = input.substring(sequenceStart);
        } else {
            sequence = input.substring(sequenceStart, sequenceEnd);
        }
        sequenceStart = sequenceEnd + 1;

        return sequence;
    }

}
